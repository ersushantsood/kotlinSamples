import java.io.File
import java.lang.NumberFormatException
import java.lang.StringBuilder

fun main() {

    //getting the list of files from the input directory
    val files = File("./input").listFiles()


    for(file in files) {

        //analyse only the csv files
        if (file.path.endsWith((".csv"))){

            //getting the content of the file line by line
            val input: List<String> = File(file.path).readLines()

            // separate the header row from the rest of the content
            val lines = input.takeLast(input.count() -1)
            val  head : List<String> = input.first().split(",")

            var text = StringBuilder("[")

            for(line in lines) {

                val values = line.split(",")

                text.appendln("{")

                for( i in 0 until values.count()){

                    val element = getElement(values[i].trim())

                    text.append("\t\"${head[i]}\": $element" )

                    if(i!= values.count() -1){
                        text.append(",")
                    }
                    else{
                        text.appendln()
                    }
                }
                text.append("},")
            }

            // remove the last comma
            text.deleteCharAt(text.length-1)
            // close the JSON array
            text.appendln("]")

            val newFile = file.path.replace(".csv",".json")
            File(newFile).writeText(text.toString())
        }
    }
}

fun isNumeric(text:String): Boolean =

        try {
            text.toDouble()
            true
        }
        catch (e: NumberFormatException){
            false
        }


fun getElement(text: String): String {

    when {

        // items to return as they are
        text == "true" || text == "false" || text == "null" || isNumeric(text) -> return text
        // strings must be returned between double quotes
        else -> return "\"$text\""
    }
}
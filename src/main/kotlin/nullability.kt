fun main() {

    //permitted null assignment syntax
    var null_val : String? = null

    //non-permitted null syntax
    //var null_not_allowed : String = null

    //unsafe text
    var unsafetext : String? = null

    //Below is not going to compile
    //val size = unsafetext.length

    //safe call operator (?.) and elvis operator (?:)
    val size = unsafetext?.length ?: -1
    print("size of unsafetext"+size)

    //non-null assertion operator (!!)
    val size_nonnullAssert = unsafetext!!.length   //As unsafetext is null so !! will assert the null value into NullPointerException
    print("Non-Null Assertion "+ size_nonnullAssert)

}
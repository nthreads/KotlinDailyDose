/***********************
 * Kotlin - Daily Dose *
 ***********************
 *    Backing Fields   *
 ***********************/

// These Java fields are known as backing fields in the Kotlin world.

data class HttpResponse(val body: String, var headers: Map<String, String>) {
        
    // The getter for hasBody returns true if the body is blank. 
    // Since Kotlin can compute the hasBody value from the body property, 
    // it won’t generate a backing field for it.
    val hasBody: Boolean
        get() = body.isNotBlank()
    
    // Every time we set the statusCode property, Kotlin will call the set(value) custom accessor. 
    // The current implementation is an endless recursive call leads to StackOverFlowError
    
    var statusCode: Int = 100
    set(value) {
        if (value in 100..599) statusCode = value
    }
    
    // To avoid this endless recursion, we can use the backing field that Kotlin generates for this property
    var statusCode: Int = 100
    set(value) {
        if (value in 100..599) field = value
    }
}
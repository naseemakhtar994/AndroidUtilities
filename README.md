[![](https://jitpack.io/v/munix/AndroidUtilities.svg)](https://jitpack.io/#munix/AndroidUtilities)


[Javadoc](http://munix.github.io/AndroidUtilities)

To get a Git project into your build:
===

Step 1. Add it in your root build.gradle at the end of repositories:

allprojects {

    repositories {
    
		...
		
	    maven { url "https://jitpack.io" }
	    
    }
    
}

Step 2. Add the dependency to your project build.gradle

dependencies {

    compile 'com.github.munix:AndroidUtilities:v0.8b'
    
}
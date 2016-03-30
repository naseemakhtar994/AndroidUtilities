[![](https://jitpack.io/v/munix/AndroidUtilities.svg)](https://jitpack.io/#munix/AndroidUtilities)


Docs
====

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
        compile 'com.github.munix:AndroidUtilities:v1.0'
    }
   
   
   
How do I solve peer not authenticated error in Gradle?
===

If you are running Gradle on Linux you might get the peer not authenticated error. 
Edit your gradle/wrapper/gradle-wrapper.properties and set distributionUrl to https\://services.gradle.org/distributions/gradle-2.11-all.zip

Ex: distributionUrl=https\://services.gradle.org/distributions/gradle-2.11-all.zip
   

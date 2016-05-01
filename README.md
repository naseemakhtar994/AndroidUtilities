[![](https://jitpack.io/v/munix/AndroidUtilities.svg)](https://jitpack.io/#munix/AndroidUtilities)


Docs
--------

[Javadoc](http://munix.github.io/AndroidUtilities)

Download
--------

Step 1. Add it in your root build.gradle at the end of repositories:


    allprojects {
        repositories {
		    ...
	        maven { url "https://jitpack.io" }
        }
    }

Step 2. Add the dependency to your project build.gradle


    dependencies {
        compile 'com.github.munix:AndroidUtilities:+'
    }
   
   
   
How do I solve peer not authenticated error in Gradle?
-------

If you are running Gradle on Linux you might get the peer not authenticated error. 
Edit your gradle/wrapper/gradle-wrapper.properties and set distributionUrl to https\://services.gradle.org/distributions/gradle-2.11-all.zip

Ex: distributionUrl=https\://services.gradle.org/distributions/gradle-2.11-all.zip

License
-------

    Copyright 2013-2016 Philip Schiffer

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
   

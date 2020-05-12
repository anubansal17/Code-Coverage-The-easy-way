# Improving Code Coverage, the Eclipse Plugins way
Developed solution for improvimg code coverage for any production code using eclipse plugins </br>
Worked solely on the project and completed it in 2 weeks </br>

# Project Status: Done
# Project Documentation: In-Process
So much occupied with the office work, will complete the documentation soon.</br>
This is kinda project report that I have to submit to my college for 8th sem evaluation.</br>

# Description: 
To find APIs for untested methods through code. Code coverage improved by 95% after the work has been completed. I wrote a script in java which automatically finds the callers for the untested methods and ultimately finds its annotations to hit those methods through APIs if it exists or else marks it as deprecated and handed over the results to QA for hitting those APIs through tests.</br>

# Installation
- Download the latest version of eclipse(Though, I have used 2020-03 version) and install it for Java Enterprise as it consists of all the necessary dependencies for the project. You don't need to install anything separately.
- Once everything is installed, create new plugin project using the Hello World template.

# About Code Written
Actual code written for the project is different from the one shared above, have modified it a lot to find callers for IMethods by passing method name, class name and package name to its function and then further it finds callers for the found caller methods and the process goes on until it finds the annotations for the method or all the callers in the list for given method have been explored</br>

# Quick Walk Through to run project for any Code Coverage analysis
- Firstly, upload the excel sheet in your eclipse plugin project taken from Code Coverage Analysis(Sealights) containing all the methods for which you need to find the Apis. Please make sure the format of the details related to each method must be same as the sample mentioned below, as the code is designed for this input format only 
  - Steps to upload the document in plugin project:
    - Select import option from file menu in top left corner of eclipse
    - Select File System under the General section and then press next
    - In 'from directory' field, search the directory where your excel sheet is present in your system and after this select       your sheet from all the files present in the directory
    - In 'Into folder' field, select your plugin project
    - Press finish and your sheet is now uploaded in your eclipse project successfully
    - Refer to the screenshot attached below:
    
- After uploading the file, you need to mention the name of sheet in the code. You can find the variable named 'filename'.
  Please set its value as the name of your file alongwith extension.
- Boom! you are done with everything you needed to run the project for your code coverage analysis.
- Run the project as Eclipse Application and press the option on the top left corner to execute the code
- After successful execution, you

# Results

# References
https://stackoverflow.com/questions/13980726/using-search-engine-to-implement-call-hierarchy-getting-all-the-methods-that-in </br>
https://stackoverflow.com/questions/844759/eclipse-stuck-when-building-workspace </br>
https://stackoverflow.com/questions/5744520/adding-jars-to-a-eclipse-plugin </br>


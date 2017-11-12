Documentation for the Java version
==================================

Navigate on the command line to the same folder as this README file. You can use maven to run the tests:

	mvn install

There are instructions for managing your test cases in the top-level README file. For the Java version these are the values for the environment variables:

    $>set TEXTTEST_HOME = $PWD/src/it/texttest
    $>set TEXTTEST_TMP = $PWD/target/sandbox

Note that $PWD should print the full path of the current working directory. On some unix versions this doesn't work, so be prepared to write out the full path.

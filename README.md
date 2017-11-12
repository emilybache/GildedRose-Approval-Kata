Gilded Rose Approval Kata with TextTest
=======================================

This repo has the same production code as the GildedRose-Refactoring-Kata, but the tests are set up with TextTest instead of a unit testing framework.

There are more specific instructions in README files under each language subfolder. In each case, you need to know two paths:

    $TEXTTEST_HOME - the location of the test definition files, which are under version control
    $TEXTTEST_TMP - the location of the sandbox folder where texttest stores results from the latest test run. This is not under version control, in fact it is deleted when you start a new test run.

These are not the same for each language. Once you know these two paths, then the instructions below explain how to manage your test cases, approve results etc.

Managing test cases
-------------------

If you want to use the TextTest GUI to manage tests and inspect results (which is probably more convenient than using the command line) you will need to install pygtk and some other tools. Please see [TextTest docs](http://texttest.sourceforge.net/index.php?page=documentation_3_27&n=install_texttest).

When you have done that you should be able to start texttest like this:

    texttest -d $PWD/texttest -c $PWD -a gr

Otherwise, you can do everything you need to on the command line or via a file management tool.

Viewing results
---------------

When you have run your tests it should tell you if they fail, and which files had differences. To inspect the output from the test run, look under $TEXTTEST_TMP for a folder named 'gr.xxxxx.xxxxx' where xxxxx.xxxxx is a timestamp unique for each test run. Under there you should find a folder structure matching the test definition folder structure that you have under $TEXTTEST_HOME. To view the contents of a particular file, for example the standard output:

    $> cat $TEXTTEST_TMP/gr.12Nov114423.12044/gr/foo/stdout.gr
    OMGHAI!
    -------- day 0 --------
    name, sellIn, quality
    Sulfuras, Hand of Ragnaros, 0, 80

    -------- day 1 --------
    name, sellIn, quality
    Sulfuras, Hand of Ragnaros, 0, 80
    ...

You can diff this against the approved version of the file (if there is one):

    diff $TEXTTEST_TMP/gr.12Nov114423.12044/gr/foo/stdout.gr $TEXTTEST_HOME/foo/stdout.gr

Of course, if the test passed then there will be no differences.

Approving results
-----------------

If you want to approve some output, copy it from the temporary test run folder into the test definition folder. For example:

    $> cp $TEXTTEST_TMP/gr.xxxxx.xxxxx/gr/foo/stdout.gr $TEXTTEST_HOME/foo
    $> cp $TEXTTEST_TMP/gr.xxxxx.xxxxx/gr/foo/stderr.gr $TEXTTEST_HOME/foo

Renaming tests
--------------

If you want to rename the test so it is no longer named 'foo', rename the folder where the test definition is kept:

    $> mv $TEXTTEST_HOME/foo $TEXTTEST_HOME/some_better_testname

You must additionally update the 'testsuite.gr' file so it lists the new test name:

    $> cat $TEXTTEST_HOME/testsuite.gr
    some_better_testname

Adding a new test case
----------------------

To add a new test case, create a new folder under $TEXTTEST_HOME containing (at least) an 'items.csv' file. You must also add the folder name on a new line in testsuite.gr:

    $> mkdir $TEXTTEST_HOME/another_testcase
    $> touch $TEXTTEST_HOME/another_testcase/items.csv
    $> cat $TEXTTEST_HOME/testsuite.gr
    some_better_testname
    another_testcase



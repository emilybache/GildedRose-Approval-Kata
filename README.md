Gilded Rose Approval Kata with TextTest
=======================================

This repo has the same production code as the GildedRose-Refactoring-Kata, but the tests are set up with TextTest instead of a unit testing framework.

Running the texttests
---------------------

You will need to point out the location of your clone of the code, so that texttest can find it. In your personal texttest config file $HOME/.texttest/config (create that file if it doesn't exist), include this:

    [checkout_location]
    gilded-rose:$SOURCE_ROOT/GildedRose-Approval-Kata/java

Where $SOURCE_ROOT is a the path on your machine to this repo.

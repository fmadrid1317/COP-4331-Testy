#!/bin/bash

# Bryan Owen

# BasicFunctionality: test-all.sh
# You can run this script at the command line like so:
#
#   bash test-all.sh

################################################################################
# Shell check.
################################################################################

if [ "$BASH" != "/bin/bash" ]; then
  echo ""
  echo " Use bash to run this script, like so: bash test-all.sh"
  echo ""
  exit
fi

if [ -z "$BASH_VERSION" ]; then
  echo ""
  echo " Use bash to run this script, like so: bash test-all.sh"
  echo ""
  exit
fi

#Init

PASS_CNT=0
NUM_TEST_CASES=5


#Are all files present?

if [ ! -f BasicFunctionality.java ]; then
	echo ""
	echo " Error: You must place BasicFunctionality.java in this directory before we can"
	echo "        proceed. Aborting test script."
	echo ""
	exit
elif [ ! -d sampleoutput ]; then
	echo ""
	echo " Error: You must place the sampleoutput folder in this directory"
	echo "        before we can proceed. Aborting test script."
	echo ""
	exit
elif [ ! -d inputfiles ]; then
	echo ""
	echo " Error: You must place the inputfiles folder in this directory"
	echo "        before we can proceed. Aborting test script."
	echo ""
	exit
fi

for i in `seq -f "%02g" 1 $NUM_TEST_CASES`;
do
	if [ ! -f test-case$i.java ]; then
		echo ""
		echo " Error: You must place test-case$i.java in this directory before we"
		echo "        can proceed. Aborting test script."
		echo ""
		exit
	fi
done

for i in `seq -f "%02g" 1 $NUM_TEST_CASES`;
do
	if [ ! -f sampleoutput/test-case$i-output.txt ]; then
		echo ""
		echo " Error: You must place test-case$i-output.txt in the sampleoutput directory"
		echo "        before we can proceed. Aborting test script."
		echo ""
		exit
	fi
done

for i in `seq -f "%02g" 1 $NUM_TEST_CASES`;
do
	if [ ! -f inputfiles/test-case$i-input.txt ]; then
		echo ""
		echo " Error: You must place test-case$i-input.txt in the inputfiles directory"
		echo "        before we can proceed. Aborting test script."
		echo ""
		exit
	fi
done


#Compile and Run

echo ""
echo "================================================================"
echo "Running test cases..."
echo "================================================================"
echo ""

for i in `seq -f "%02g" 1 $NUM_TEST_CASES`;
do
	echo -n "  [Test Case] Checking test-case$i... "

	# Attempt to compile.
	javac BasicFunctionality.java test-case$i.java 2> /dev/null
	compile_val=$?
	if [[ $compile_val != 0 ]]; then
		echo "** fail ** (failed to compile)"
		continue
	fi

	# Run program. Capture return value to check whether it crashes.
	java test-case$i > myoutput.txt 2> /dev/null
	execution_val=$?
	if [[ $execution_val != 0 ]]; then
		echo "** fail ** (program crashed)"
		continue
	fi

	# Run diff and capture its return value.
	diff myoutput.txt sampleoutput/test-case$i-output.txt > /dev/null
	diff_val=$?
	
	# Output results based on diff's return value.
	if  [[ $diff_val != 0 ]]; then
		echo "** fail ** (output does not match)"
	else
		echo "PASS!"
		PASS_CNT=`expr $PASS_CNT + 1`
	fi
done

if [ $NUM_TEST_CASES -ne 9 ]; then
	FIRST_SKIPPED=`expr $NUM_TEST_CASES + 1`
	for i in `seq -f "%02g" $FIRST_SKIPPED 9`;
	do
		echo "  [Test Case] Checking test-case$i... ** skipped **"
	done
fi

#Cleanup

rm -f *.class
rm -f GenericBST__warning.err
rm -f myoutput.txt


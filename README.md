# tlvprocessor

Technology stack
 - Java (jdk1.8.0_45)
 - Maven
 
 Process TLVs with the following format 
   Format: TYPE(6)-LENGTH(4)-VALUE 
   Type - fixed 6 chars length. Defines the type of processing required. 
   Length - fixed 4 chars (represented as text) length of the value. 
   Value - the actual data to be processed of length 'Length' above.
   
A simple TLV Processor which process the given instructions currently supports the type UPPRCS - converts the value to the Uppercase, 
REPLCE - replace value with the 'THIS STRING' and for invalid types "Type not valid".

Designed with extensibility for easily adding new processor and input streams.

Input is specified on StdIn and output is expected on StdOut

The test is run as follow: 
java -jar tlvprocessor.jar
   
Input: 
UPPRCS-0005-abcde
REPLCE-0003-123
UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z
TAG001-0012-abcdefgh1234
UPPRCS-0004-1234

Output: 
UPPRCS-ABCDE
REPLCE-THIS STRING
UPPRCS-ABCDEFGH
REPLCE-THIS STRING
REPLCE-THIS STRING
Type not valid
UPPRCS-1234

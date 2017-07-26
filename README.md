# BBDN-DevCon-LTISampleApplicationWithREST

The example shows how to build a simple LTI Tool Provider as a building block in Learn and then make REST calls in it to gather additional data.

This provides a means of creating or porting existing course, user, system tools, etc. into LTI Providers so they can be used in Ultra courses that leverage the public REST API's.

To install & configure:

1.  Build this application and install the B2.
2.  Register your REST application at developer.blackboard.com.  Note the application ID, key & secret.
3.  Update your Bb Learn system with the application ID.
4.  Update the key and secret in the B2 settings with the values for the REST application.  You will use the same one for both the LTI & REST for this example.
5.  Add an LTI provider domain for the same url as the server where you are running this.
6.  Create LTI links or placements in your courses using the same key & secret.  The LTI url will be <bb home>/webapps/xyz-LTISampleApplication-BBLEARN/app/launch.

To extend this example:

Add to the Launch Controller hooks to direct to the various functions based on the action code.  Likely it makes sense to implemnt this functionality as a variety of services & additional views.

You will also want to add processing to ensure the correct user & role can use this tool.

The latest available public REST API set can be found at developer.blackboard.com.  You can consult this list and add additional functionality as you wish in this example.
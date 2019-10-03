=========================================================================================================================================

To import the custom source,sink,processor, task

1. Build the jar and host in on any artifactory that is accessible from the SCDF environment.
2. Open SCDF Dashboard
3. Click on Apps
4. Click on "Add Application" button
5. Fill in the details and submit. It will be imported.
=========================================================================================================================================


To Configure http stream copy paste the following:
http-filer-ob: http --port=8123 | filter --expression=#jsonPath(payload,'$.origin.country').equals('IN') | http-log: log

SAMPLE JSON:
{"origin":{"id":3,"country":"IN","name":"cts"}}


===========================================================================================================================================

To configure twitter stream:

twitter-stream: twitterstream --consumer-secret='******' --consumer-key='******' --access-token='******' --track=ICC,cricket,bcci --access-token-secret='******' | mongo-dump: mongodb --collection=test --uri=mongodb://test1:test1@18.188.129.154:27017/admin

Check for the mongo URL and replace the key and secret.
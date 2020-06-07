<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >

<suite name="REST_Test_Suite" parallel="false">
    <test name="REST_Tests">
        <classes>
            <class name="com.example.test.RestTest">
                <methods>
                    <include name="getSecondPageOfUsers" />
                    <include name="createUser" />
                    <exclude name="getSecondPageOfUsers_checkResponseCode_expect200" />
                    <exclude name="getSecondPageOfUsers_checkPageNumber" />
                    <exclude name="getSecondPageOfUsers_checkPageItemCount" />
                    <exclude name="getSecondPageOfUsers_checkTotalElements" />
                    <exclude name="getSecondPageOfUsers_checkTotalPages" />
                </methods>
            </class>
        </classes>
    </test>
</suite>
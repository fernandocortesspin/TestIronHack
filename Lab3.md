# LAB 3

**Scenario 1: User Authentication Tests**

Original Test Case (Pseudocode)

    TEST UserAuthentication
        ASSERT_TRUE(authenticate("validUser", "validPass"), "Should succeed with correct credentials")
        ASSERT_FALSE(authenticate("validUser", "wrongPass"), "Should fail with wrong credentials")
    END TEST

<u>Analysis report</u>

* Test does no have clear description/naming
* Test contains 2 different scenarios (success, error) in the same test and must be separated in different unit test
* Test is not declaring constants for different parameters data for case correct data and wrong data

<u>Review</u>

* Rewrite descriptive naming/title for each unit test methods
* Implement success/wrong scenarios in separated unit test for specific cases
* Can create and mock nested/intern layer that really execute de authentication process and define result expected, for success/wrong scenario
* If both cases are using this inter/nested layer, we can use Global object with BEFORE ALL/EACH and CLEAR objects


<u>Solution  in Pseudocode</u>

    // Defining global variable</br>
    DataService dataService;

    BEFORE ALL
    
        dataService =  Mock(DataService)
    
    END BEFORE</br>

    // success scenario</br>

    TEST userAuthentication_usingCorrectPasswordShouldBeSuccessful </br>
    
        // Stub
        WHEN dataService.isValid( any(), any()) RETURNS true
    
        ASSERT_TRUE(authenticate("validUser", "validPass"), "Should succeed with correct credentials")
    
        //cLear
        dataService.clear
    
    END TEST

    // error scenario

    TEST userAuthentication_usingWrongPasswordShouldBeAnError

        // Stub
        DataService dataService =  Mock(DataService)
        WHEN dataService.isValid( any(), any()) RETURNS true
    
        ASSERT_FALSE(authenticate("validUser", "wrongPass"), "Should fail with wrong credentials")
        
        //clear
        dataService.clear

    END TEST


————————————————————————————————————————————
————————————————————————————————————————————
<br>
<br>

**Scenario 2: Data Processing Functions**

Original Test Case (Pseudocode)

    TEST DataProcessing

        DATA data = fetchData()

        TRY
            processData(data)
            ASSERT_TRUE(data.processedSuccessfully, "Data should be processed successfully")
       
         CATCH error
            
            ASSERT_EQUALS("Data processing error", error.message, "Should handle processing errors")
    
        END TRY

    END TEST

<u>Analysis report</u>

* Test does no have clear description/naming
* Test contains 2 different scenarios (success, error) in the same test and must be separated in different unit test

<u>Review</u>

* Rewrite descriptive naming/title for each unit test methods
* Implement success/wrong scenarios in separated unit test for specific cases
* Define constants to given input data

<u>Solution in pseudocode</u>

    // success scenario

    TEST dataProcessing_withCorrectDataShouldBeASuccesfulProcess

        //Defining constants
            DATA data = TestUtil.getCorrectData()
    
        processData(data)
    
        ASSERT_TRUE(data.processedSuccessfully, "Data should be processed successfully")
    END TEST

    
    // scenario with exception and handling error

    TEST dataProcessing_usingWrongDataThrowsExceptionAndHandleError
    TRY
        
        DATA data = TestUtil.getWrongData()
    
        processData(data)
    
        CATCH error
            ASSERT_EQUALS("Data processing error", error.message, "Should handle processing errors")
        END TRY
    END TEST

————————————————————————————————————————————
————————————————————————————————————————————

**Scenario 3: UI Responsiveness**

Original Test Case (Pseudocode)

    TEST UIResponsiveness
        UI_COMPONENT uiComponent = setupUIComponent(1024)
        ASSERT_TRUE(uiComponent.adjustsToScreenSize(1024), "UI should adjust to width of 1024 pixels")
    END TEST


<u>Analysis report</u>

* Test does no have clear description/naming

<u>Review</u>

* Rewrite descriptive naming/title for each unit test methods

<u>Solution in pseudocode</u>

    TEST UIResponsiveness_shouldAdjustToWidthByPixelsParamIndicated
    
         UI_COMPONENT uiComponent = setupUIComponent(1024)
         ASSERT_TRUE(uiComponent.adjustsToScreenSize(1024), "UI should adjust to width of 1024 pixels")
    
    END TEST

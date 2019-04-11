Feature: Android - EMULATOR-NATIVE-UI
  As a user
  I want to

  Scenario Outline: Android Emulator - <config> - Do operation with the calculator app

    Given <config> appium driver
      | field           | data                               |
      | appPackage      | com.android.calculator2            |
      | appActivity     | com.android.calculator2.Calculator |
      | appWaitActivity | com.android.calculator2.Calculator |
      | appWaitDuration | 3000                               |
    When I add <first_num> and <second_num>
    Then I check that result is equal to <expected_result>

    Examples:
      | config                                     | first_num | second_num | expected_result |
      | android_nexus6_android7.1.1_default_config | 40        | 9          | 49              |
      | android_nexus6_android7.1.1_default_config | 368       | 10         | 378             |

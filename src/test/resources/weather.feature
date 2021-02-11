Feature: Weather API

  Scenario: Testing city coordinates
    Given city id: 524901
    When we are requesting weather data
    Then lon is 145.77
    And lat is -16.92

    And base is "stations"

#    And main temp is 300.15
#    And main pressure is 1007
#    And main humidity 74
#    And main min temp 300.15
#    And main max temp 300.15

    And main data is:
      | temp     | 300.15 |
      | pressure | 1007   |
      | humidity | 74     |
      | temp_min | 300.15 |
      | temp_max | 300.15 |
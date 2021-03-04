Feature: Weather API

  Scenario: Weather data for city by ID
    Given city id: 524901

    When we are requesting weather data

    Then lon is: 145.77
    And lat is: -16.92

    And weather is:
      | id          | 802              |
      | main        | Clouds           |
      | description | scattered clouds |
      | icon        | 03n              |
Feature: Get Pizzas

  Scenario: Fetch all Pizzas
    Given the shop has a pizza "Margherita"
    And the shop has a pizza "Pepperoni"
    When I request "/pizzas"
    Then the response code is 200
    And the response body is
    """
    [{"id":101010,"name":"Margherita"},{"id":202020,"name":"Pepperoni"}]
    """
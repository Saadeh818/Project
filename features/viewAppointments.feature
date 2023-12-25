Feature: View Appointment
  Customer can view his Appointment

  Scenario: view Appointment
    When view Appointment methode been called
    Then show all appintments related to the customer

    Scenario: view Appointments
      When view Appointment methode been called by Installer
      Then Show all appointments

Feature: US1001 Kullanici Database'e baglanip read yapabilir
  @not
  Scenario: TC01 kullanici database baglanip istediği verileri okuyabilmeli

    Given kullanici HMC veri tabanina baglanir
    And kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    # SELECT Price FROM tHOTELROOM
    And kullanici "Price" sutunundaki verileri okur
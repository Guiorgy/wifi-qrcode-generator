package com.devjan.wifiqrcodegenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unittest for the class {@link WifiQrCodeGenerator}
 *
 * @author Jan Bucher
 */
public class WifiQrCodeGeneratorTest {
  private final String samplePass = "samplePass";

  @Test
  public void test_getPayloadString_wpa() {
    // Arrange
    WifiQrCodeGenerator generator = new WifiQrCodeGenerator();
    generator.withAuthenticationMode(AuthenticationMode.WPA)
             .withSsid("someSuperNetwork")
             .withPassword(samplePass);

    // Act
    String qrPayload = generator.getPaylodString();

    // Assert
    assertEquals("WIFI:T:WPA;S:someSuperNetwork;P:" + samplePass + ";;", qrPayload);
  }

  @Test
  public void test_getPayloadString_wep() {
    // Arrange
    WifiQrCodeGenerator generator = new WifiQrCodeGenerator();
    generator.withAuthenticationMode("WEP")
             .withSsid("unsecureNetwork")
             .withPassword(samplePass);

    // Act
    String qrPayload = generator.getPaylodString();

    // Assert
    assertEquals("WIFI:T:WEP;S:unsecureNetwork;P:" + samplePass + ";;", qrPayload);
  }

  @Test
  public void test_getPayloadString_unsecure() {
    // Arrange
    WifiQrCodeGenerator generator = new WifiQrCodeGenerator();
    generator.withAuthenticationMode(AuthenticationMode.NOPASS)
             .withSsid("openNetwork");

    // Act
    String qrPayload = generator.getPaylodString();

    // Assert
    assertEquals("WIFI:T:NOPASS;S:openNetwork;P:;;", qrPayload);
  }

  @Test
  public void test_toString() {
    // Arrange
    WifiQrCodeGenerator generator = new WifiQrCodeGenerator();
    generator.withAuthenticationMode(AuthenticationMode.NOPASS)
             .withSsid("openNetwork");

    // Act
    String result = generator.toString();

    // Assert
    assertTrue(result.contains("openNetwork"), "toString() should contain the network name");
  }

}

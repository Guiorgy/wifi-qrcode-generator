package com.devjan.wifiqrcodegenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import picocli.CommandLine;

/**
 * JUnit test for the class {@link Main}
 *
 * @author Jan Bucher
 */
public class MainTest {
  @Test
  public void test_cli() {
    // Arrange
    String[] args = {"--ssid=test", "example.png"};

    // Act
    CommandLine cmd = new CommandLine(new Main());
    int exitCode = cmd.execute(args);

    // Assert
    assertEquals(0, exitCode);
  }

}

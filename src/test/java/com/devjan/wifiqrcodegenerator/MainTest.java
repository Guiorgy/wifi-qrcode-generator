package com.devjan.wifiqrcodegenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import picocli.CommandLine;

/**
 * JUnit test for the class {@link Main}
 *
 * @author Jan Bucher
 */
public class MainTest {
  @Test
  public void test_cli(@TempDir Path tempDir) {
    // Arrange
    Path outputFile = tempDir.resolve("example.png");
    String[] args = {"--ssid=test", outputFile.toString()};

    // Act
    CommandLine cmd = new CommandLine(new Main());
    int exitCode = cmd.execute(args);

    // Assert
    assertEquals(0, exitCode);
    assertTrue(Files.exists(outputFile));
  }

}

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class PortabilityMetrics {

    // Tokens that might indicate platform-dependent code (empty for platform-agnostic code).
    private static final List<String> DEPENDENT_TOKENS = Arrays.asList(
            // e.g., "com.sun.", "org.w3c.dom." if considered non-portable.
    );

    // Allowed import prefixes for portability.
    private static final List<String> ALLOWED_IMPORT_PREFIXES = Arrays.asList(
            "import java.",
            "import javax.",
            "import Simpler_Solution.",
            "import Adapter_Pattern.",
            "import Bridge_Pattern.",
            "import Common_Class."
    );

    // Helper method to calculate line-based metrics for a given directory.
    private MetricsResult calculateLineBasedMetrics(String directory) throws IOException {
        MetricsResult result = new MetricsResult();
        Files.walk(Paths.get(directory))
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(path -> {
                    try {
                        List<String> lines = Files.readAllLines(path);
                        result.totalLines += lines.size();
                        for (String line : lines) {
                            for (String token : DEPENDENT_TOKENS) {
                                if (line.contains(token)) {
                                    result.dependentLines++;
                                    break;  // Count each line only once.
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        return result;
    }

    // Helper method to calculate the import-based portability metric for a single file.
    private double calculateImportPortability(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        int totalImports = 0;
        int allowedImports = 0;
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("import ")) {
                totalImports++;
                boolean allowed = false;
                for (String prefix : ALLOWED_IMPORT_PREFIXES) {
                    if (line.startsWith(prefix)) {
                        allowed = true;
                        break;
                    }
                }
                if (allowed) {
                    allowedImports++;
                }
            }
        }
        // If there are no import statements, assume 100% portability.
        return totalImports > 0 ? (double) allowedImports / totalImports : 1.0;
    }

    @Test
    public void testSimplerSolutionMetrics() throws IOException {
        String directory = "src/main/java/Simpler_Solution";
        MetricsResult result = calculateLineBasedMetrics(directory);
        System.out.println("Simpler Solution - Total LOC: " + result.totalLines);
        System.out.println("Simpler Solution - Platform Dependent LOC: " + result.dependentLines);

        // Using import-based technique on a representative file.
        String sampleFile = directory + "/Inventory.java";
        double importPortability = calculateImportPortability(sampleFile);
        System.out.println("Simpler Solution Import Portability Ratio: " + importPortability);
        assertTrue(importPortability > 0.95, "Most imports should be platform-independent");
    }

    @Test
    public void testAdapterPatternMetrics() throws IOException {
        String directory = "src/main/java/Adapter_Pattern";
        MetricsResult result = calculateLineBasedMetrics(directory);
        System.out.println("Adapter Pattern - Total LOC: " + result.totalLines);
        System.out.println("Adapter Pattern - Platform Dependent LOC: " + result.dependentLines);

        String sampleFile = directory + "/InventoryAdapter.java";
        double importPortability = calculateImportPortability(sampleFile);
        System.out.println("Adapter Pattern Import Portability Ratio: " + importPortability);
        assertTrue(importPortability > 0.95, "Most imports should be platform-independent");
    }

    @Test
    public void testBridgePatternMetrics() throws IOException {
        String directory = "src/main/java/Bridge_Pattern";
        MetricsResult result = calculateLineBasedMetrics(directory);
        System.out.println("Bridge Pattern - Total LOC: " + result.totalLines);
        System.out.println("Bridge Pattern - Platform Dependent LOC: " + result.dependentLines);

        String sampleFile = directory + "/InventoryBridge.java";
        double importPortability = calculateImportPortability(sampleFile);
        System.out.println("Bridge Pattern Import Portability Ratio: " + importPortability);
        assertTrue(importPortability > 0.95, "Most imports should be platform-independent");
    }

    // Helper class to hold metric results.
    private static class MetricsResult {
        int totalLines = 0;
        int dependentLines = 0;
    }
}

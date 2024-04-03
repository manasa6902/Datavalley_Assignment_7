/*3. Write a Java program that accepts a list of medical test
results and returns the number of patients with results
falling within specific ranges (e.g., normal, borderline,
high), and the average value for each range.
*/

class MedicalTestResult {
    private String patientName;
    private double resultValue;
    
    public MedicalTestResult(String patientName, double resultValue) {
        this.patientName = patientName;
        this.resultValue = resultValue;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public double getResultValue() {
        return resultValue;
    }
}

public class MedicalTestResultsAnalyzer {
    public static void main(String[] args) {
        List<MedicalTestResult> testResults = new ArrayList<>();
        
        testResults.add(new MedicalTestResult("Priya", 75.0));
        testResults.add(new MedicalTestResult("Hani", 110.0));
        testResults.add(new MedicalTestResult("Pavan", 90.0));
        testResults.add(new MedicalTestResult("Chandu", 60.0));
        testResults.add(new MedicalTestResult("Shannu", 140.0));
        
        Map<String, Integer> patientsByResultRange = new HashMap<>();
        Map<String, Double> averageValueByResultRange = new HashMap<>();
        
        String[] resultRanges = {"Normal", "Borderline", "High"};
        for (String range : resultRanges) {
            patientsByResultRange.put(range, 0);
            averageValueByResultRange.put(range, 0.0);
        }
        
        for (MedicalTestResult result : testResults) {
            double value = result.getResultValue();
            String range = getResultRange(value);
            
            patientsByResultRange.put(range, patientsByResultRange.get(range) + 1);
            averageValueByResultRange.put(range, averageValueByResultRange.get(range) + value);
        }
        
        for (String range : resultRanges) {
            int patients = patientsByResultRange.get(range);
            double averageValue = averageValueByResultRange.get(range) / patients;
            averageValueByResultRange.put(range, averageValue);
        }
        
        System.out.println("Number of patients with results falling within specific ranges and average value for each range:");
        for (String range : resultRanges) {
            System.out.println(range + ": Patients - " + patientsByResultRange.get(range) + ", Average Value - " + averageValueByResultRange.get(range));
        }
    }
    
    private static String getResultRange(double value) {
        if (value <= 100.0) {
            return "Normal";
        } else if (value <= 130.0) {
            return "Borderline";
        } else {
            return "High";
        }
    }
}
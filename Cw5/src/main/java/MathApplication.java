public class MathApplication {
    private CalculatorService calcService;

    public void setCalculatorService(CalculatorService calcService){
        this.calcService = calcService;
    }

    public double add(double input1, double input2){
        return calcService.add(input1, input2);
    }

    public double subtract(double input3, double input4){
        return calcService.subtract(input3, input4);
    }

    public double multiply(double input5, double input6){
        return calcService.multiply(input5, input6);
    }

    public double divide(double input7, double input8){
        return calcService.divide(input7, input8);
    }
}
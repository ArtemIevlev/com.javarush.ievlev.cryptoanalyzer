package entiti;

public class Result {
    private final String massage;
    private final ResultCode resultCode;

    public Result(String massage, ResultCode resultCode) {
        this.massage = massage;
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode() {
        return resultCode;
    }

    @Override
    public String toString() {
        return "Result{" +
                "massage='" + massage + '\'' +
                ", resultCode=" + resultCode +
                '}';
    }
}

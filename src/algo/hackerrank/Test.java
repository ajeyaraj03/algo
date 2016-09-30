package algo.hackerrank;

/**
 * Created by ajeya.hb on 11/09/16.
 */
public class Test {
    private String stackName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;

        Test test = (Test) o;

        return stackName != null ? stackName.equals(test.stackName) : test.stackName == null;

    }

    @Override
    public int hashCode() {
        return stackName != null ? stackName.hashCode() : 0;
    }
}

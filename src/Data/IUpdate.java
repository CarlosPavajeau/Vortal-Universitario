package Data;

public interface IUpdate
{
    boolean Update(String primaryKey, String columName, Object newValue);
}

package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class M15 {

    @SerializedName("Key")
    @Expose
    private String key;
    @SerializedName("Value")
    @Expose
    private Integer value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}

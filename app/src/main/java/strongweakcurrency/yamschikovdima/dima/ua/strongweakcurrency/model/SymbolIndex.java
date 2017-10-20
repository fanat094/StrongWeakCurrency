
package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SymbolIndex {

    @SerializedName("StrongWeakPair")
    @Expose
    private String strongWeakPair;
    @SerializedName("Strongest")
    @Expose
    private String strongest;
    @SerializedName("TimeFrame")
    @Expose
    private String timeFrame;
    @SerializedName("Weakest")
    @Expose
    private String weakest;

    public String getStrongWeakPair() {
        return strongWeakPair;
    }

    public void setStrongWeakPair(String strongWeakPair) {
        this.strongWeakPair = strongWeakPair;
    }

    public String getStrongest() {
        return strongest;
    }

    public void setStrongest(String strongest) {
        this.strongest = strongest;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getWeakest() {
        return weakest;
    }

    public void setWeakest(String weakest) {
        this.weakest = weakest;
    }

}

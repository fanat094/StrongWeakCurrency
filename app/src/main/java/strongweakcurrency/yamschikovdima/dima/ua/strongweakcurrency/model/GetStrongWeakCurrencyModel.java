
package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetStrongWeakCurrencyModel {

    @SerializedName("D1")
    @Expose
    private List<D1> d1 = null;
    @SerializedName("H1")
    @Expose
    private List<H1> h1 = null;
    @SerializedName("H4")
    @Expose
    private List<H4> h4 = null;
    @SerializedName("LastCalcTime")
    @Expose
    private Integer lastCalcTime;
    @SerializedName("M15")
    @Expose
    private List<M15> m15 = null;
    @SerializedName("SymbolIndices")
    @Expose
    private List<SymbolIndex> symbolIndices = null;

    public List<D1> getD1() {
        return d1;
    }

    public void setD1(List<D1> d1) {
        this.d1 = d1;
    }

    public List<H1> getH1() {
        return h1;
    }

    public void setH1(List<H1> h1) {
        this.h1 = h1;
    }

    public List<H4> getH4() {
        return h4;
    }

    public void setH4(List<H4> h4) {
        this.h4 = h4;
    }

    public Integer getLastCalcTime() {
        return lastCalcTime;
    }

    public void setLastCalcTime(Integer lastCalcTime) {
        this.lastCalcTime = lastCalcTime;
    }

    public List<M15> getM15() {
        return m15;
    }

    public void setM15(List<M15> m15) {
        this.m15 = m15;
    }

    public List<SymbolIndex> getSymbolIndices() {
        return symbolIndices;
    }

    public void setSymbolIndices(List<SymbolIndex> symbolIndices) {
        this.symbolIndices = symbolIndices;
    }

}

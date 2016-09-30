package games;

/**
 * Created by ajeya.hb on 10/09/16.
 */
public  class ClothData{

    private int startPos;
    private int offset;

    public ClothData(int startPos, int offset)
    {
        this.startPos = startPos;
        this.offset = offset;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClothData)) return false;

        ClothData clothData = (ClothData) o;

        if (getStartPos() != clothData.getStartPos()) return false;
        return getOffset() == clothData.getOffset();

    }

    @Override
    public int hashCode() {
        int result = getStartPos();
        result = 31 * result + getOffset();
        return result;
    }
}



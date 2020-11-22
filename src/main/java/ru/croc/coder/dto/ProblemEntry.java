package ru.croc.coder.dto;

public class ProblemEntry {
    private Long solved = 0L;
    private Long tried = 0L;
    private Long successPercentage = 0L;

    public Long getSolved() {
        return solved;
    }

    public ProblemEntry setSolved(Long solved) {
        this.solved = solved;
        this.tried = this.tried == 0 ? solved : this.tried;
        this.successPercentage = (long) ((double) solved / tried * 100);
        return this;
    }

    public Long getTried() {
        return tried;
    }

    public ProblemEntry setTried(Long tried) {
        this.tried = tried;
        this.successPercentage = (long) ((double) solved / tried * 100);
        return this;
    }

    public Long getSuccessPercentage() {
        return successPercentage;
    }
}

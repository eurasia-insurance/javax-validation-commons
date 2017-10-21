package tech.lapsa.javax.validation;

import java.time.Instant;

public final class InstantComparison implements TemporalComparison<Instant> {

    private final Instant left;
    private final Instant right;

    public InstantComparison(Instant left, Instant right) {
	this.left = left;
	this.right = right;
    }

    @Override
    public Instant left() {
	return left;
    }

    @Override
    public Instant right() {
	return right;
    }

    @Override
    public String toString() {
	return String.format("%1$s, %2$s", left, right);
    }
}

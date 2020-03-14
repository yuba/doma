package org.seasar.doma.internal.apt.processor.embeddable;

import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;

@Embeddable
public record RecordAddress(
        String city,
        @Column(name = "STREET", insertable = false)String street) {
}

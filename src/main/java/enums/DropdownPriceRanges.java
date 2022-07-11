package enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DropdownPriceRanges {
    THB_2_6("THB 2,000 - 6,000", "฿39.00"),
    THB_6_10("THB 6,001 - 10,000", "฿59.00"),
    THB_10_15("THB 10,001 - 15,000", "฿79.00"),
    THB_15_22("THB 15,001 - 22,000","฿139.00"),
    THB_22_26("THB 22,001 - 26,000","฿159.00"),
    THB_26_36("THB 26,001 - 36,000","฿179.00"),
    THB_36_65("THB 36,001 - 65,000","฿289.00");

    final String label;
    final String dynamicPrice;
}

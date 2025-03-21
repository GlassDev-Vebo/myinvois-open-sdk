/*
 * Copyright 2011-2024 AmaSeng Software Sdn. Bhd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amaseng.myinvois.models;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Builder
public class TaxCategory {
    private String id;
    private BigDecimal percent;
    private TaxScheme taxScheme;
    private Optional<String> taxExemptionReason;

    public TaxCategory(String id, BigDecimal percent, TaxScheme taxScheme , Optional<String> taxExemptionReason ) {
        this.id = id;
        this.percent = percent;
        this.taxScheme = taxScheme;
        this.taxExemptionReason = taxExemptionReason;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public TaxScheme getTaxScheme() {
        return taxScheme;
    }

    public Optional<String> getTaxExemptionReason()
    {
        return taxExemptionReason;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
        map.put("Percent", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", percent); }}); }});
        map.put("TaxScheme", new ArrayList<Object>() {{ add(taxScheme.toMap()); }});
        taxExemptionReason.ifPresent(taxExemptionReason -> map.put("TaxExemptionReason", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", taxExemptionReason); }}); }}));
        return map;
    }
}

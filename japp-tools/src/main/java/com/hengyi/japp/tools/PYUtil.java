/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hengyi.japp.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 *
 * @author jzb
 */
public class PYUtil {

    public static List<String> getFirstSpell(String cs) {
        if (isBlank(cs)) {
            return null;
        }
        List<String> result = null;
        List<Set<Character>> cs_fpys = cs.chars().mapToObj(i -> toHanyuPinyinStringArray((char) i))
                .map(a -> Arrays.stream(a).map(s -> s.charAt(0)).collect(Collectors.toSet()))
                .collect(Collectors.toList());
        for (Set<Character> fpys : cs_fpys) {
            if (result == null) {
                result = fpys.stream().map(String::valueOf).collect(Collectors.toList());
            } else {
                Stream<String> tmps = result.stream().flatMap(s -> fpys.stream().map(fpy -> s + fpy));
                result = tmps.collect(Collectors.toList());
            }
        }
        return result;
    }
}

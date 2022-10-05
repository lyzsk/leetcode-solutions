import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/10/05
 **/
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(cpdomains.length * 3);
        for (String cpdomain : cpdomains) {

        }
        for (String cpdomain : cpdomains) {
            int spaceIdx = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, spaceIdx));
            String domain = cpdomain.substring(spaceIdx + 1);
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        // for (Map.Entry<String, Integer> entry : map.entrySet()) {
        //     String subdomain = entry.getKey();
        //     int count = entry.getValue();
        //     res.add(count + " " + subdomain);
        // }
        map.entrySet().stream().forEach(domainSet -> {
            String data = domainSet.getValue() + " " + domainSet.getKey();
            res.add(data);
        });
        return res;
    }
}

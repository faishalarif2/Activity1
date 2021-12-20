/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.java.a.Faishal.Arif;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author NITRO
 */
@Controller
public class diskonBuah {
    @RequestMapping("/prosesinput")
    public String inputanuser(HttpServletRequest data, Model buah){
        String nbuah = data.getParameter("var_namabuah");
        String hbuah = data.getParameter("var_hargakilo");
        Integer chbuah = Integer.valueOf(hbuah);
        String jbuah = data.getParameter("var_jumlahbeli");
        Double cjbuah = Double.valueOf(jbuah);
        Double jumlahbayar = chbuah * cjbuah;
        Double totalbayar = null;
        Integer diskon = 0;
        Double hargadiskon = 0.0;

        if(jumlahbayar < 16000){
            totalbayar = jumlahbayar - (jumlahbayar*0/100);
            hargadiskon = jumlahbayar*diskon/100;
            
        }else if( jumlahbayar < 25000){
            diskon = 10;
            totalbayar = jumlahbayar - (jumlahbayar*10/100);
            hargadiskon = jumlahbayar*diskon/100;
        }else {
            diskon = 15;
            totalbayar = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
        }
        
        buah.addAttribute("nama",nbuah);
        buah.addAttribute("harga",chbuah);
        buah.addAttribute("perkilo",cjbuah);
        buah.addAttribute("tbayar",totalbayar);
        buah.addAttribute("discount",hargadiskon);
        buah.addAttribute("disc",diskon);
        buah.addAttribute("total",jumlahbayar);
        return "FaishalArif";
    }
}

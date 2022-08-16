package com.wrwp.pic2text.bootstrap;

import com.wrwp.pic2text.repositories.AsciiRepository;
import com.wrwp.pic2text.domain.Ascii;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootstrapData implements CommandLineRunner {
    private final AsciiRepository asciiRepository;
    public BootstrapData(AsciiRepository asciiRepository) {
        this.asciiRepository = asciiRepository;
    }
    @Override
    public void run(String ...args) throws Exception {
        Ascii horse = new Ascii();
        horse.setTitle("Horse Picture");
        horse.setDescription("This is a not very aesthetically pleasing picture of a horse. Hard to believe!");
        horse.setAsciiText("""
                888888%%8&88&#M&888&&&88888&&&&WMWWW&&&&&&WW&&&&W&&&WWW&WW#MWMaW#MW#*o#MMWWWMoM&
                8888888&&&&&&MM*8888&&&&&&WWWMW&MWWW&&W&&&WM##WWWMMWMWM#MMM#M#**M#oMMWMWWMMMWMWM
                88888888&&8MMM&&88888&&&&&MW&&&WWM##MWWWMMM*M##*M###*##MM###*#MW#dq*MMWWMMMMW#WW
                8&88&&&W&&888&&&&8&&aW&WW&MWMWWWMMM#*MMMMM###**##*o**MMMWMW##WM#bMMWM*##MMM#WWW&
                &&&&&W&W&&&&8&&&&##WWWM#MM#ha&WMMMWWMW##WMMMM##M####*#**M#####*phM#MM*#M#MM#MWW&
                &&W&&W&WW&&&&WW&&Mh*W#a*h#M##&W&WM&&WW&&WMMM##M##MW#MWM*#*#M#M#dMMM*MMMM#qqdMo*W
                WW&&&WWW&W&&8*haMMokah#bWMW&&W*MW&&WohaWM#o#o*MMMW&WMZQmL#MMM*#o#*ak**#mbakmbhwk
                W&&WWW&WWW&&&*oMoad*o&&#M&o&&MW#M*MW&&WWW#MWM#MM#z{[)-->1kMM#MW##M*#M#*oa*##WM*h
                M&&&&W&&&8&&###MW&MWM88&&8W&WM##M&&&&W&&W#WMMdU\\]ll>1n]tf~hMW#MM*#MWMWMM*oaaMMM#
                W&8&WW&&W&&*WW&W&&&WW888&&W&WM&WWW&&&WWWMWMMZ{ili!<?{Yrx/|foWMMWWMMWWWMad##MMM#M
                &&&&WWWWWM*WM&&&&&&&8888&W&8apZZwd*8&&&WW#kuiii!!>__[JopYjYzWMW&W&WWW&W#a*WWMoo*
                &&&&###MM*MWWW&&&&8oCvzcXz|~IllIll;!>-?]]+II!l!<~+-{(mWW*whkWWW&WWWWWWW*a*MMMMM*
                &W&WMM#M#WMM&&W&qvt[[}\\tjiii!!ii><~<i!i!>>ii>i<<~<~1nMWWbqMMMWMWW&WWW#WM*o*MMoo*
                WMWWMMMM#MMMMWMJ?tzYYzUCx?+~---??_+~<<<<~++?-___+<~{|hM#**#MWMWM&&WMMM&MM*o#**ha
                WM##MM#*M#MM##Y-(rzXzYYY00x\\[[[-|v(}][]]??]){-_?]}(/td#MW*WWWMW#WWWWW&MM##**#*ao
                WMo#WM**MMW*c|[|rnzLcjCa*#kmcrffJ*dOJznjjf/ju{}]+rJcnbMWMa*#MWW#MM&MMMM###***o#a
                M*#MM*M#**M#Q|tvZaMaq**hkook#Ytch&&WM#*ooooo*wLu\\_?\\cnvCoaoo#MMoMMMMMMMM#WM**o*#
                #WMWW#M#M*#MMmb#WWWooa*o*##*&Yjc#WWWMWW&&WMM#M#M#aq|tWhzOMa***###M##MMWWWMMMoo#o
                MMWWM#MMMMMWWWWMWMo**##*#MWW#zzLQZbW&WMM##M##M&M&hcJM&WZrhMM*MMWWMMMMWMMWWWWM#W#
                MWMWWMMMWWMM#MMWWWMo*M##MWM&WaJO&oZCO*WMW*WM#MM*OJmW&W#0XhMWWWWWWWWW&&W&WWWWWWWW
                *###o***####*o#***o*oooo*o****hJ0##hk*MM#***##MMMW&WWWW&a&&&&&&&W&W&&&&WW8&&&WWW
                wwqZkaoooaoahakaaaahaohbao*ho*ohQmk#*#*o*#**#*o***#*#**##oo*##*#**M#*o***oaoa*oo
                ]{)\\jxrcJO0Q0Qmbhkakaaohoabho#aooao*##*#o*#o#MMWWMWMMMMWM#MMMMM##M##*#**oo**#aoo
                hakbhbbmZZ0UXUYLLOwpdqqwpwmQZmCJffjrnrxnxnYUYwkkooo******#**oo*o*ooao**hooao*o##
                ##***M#ooookhkbhha**abkkaaokaookbqqmqZOwmqm0L0wphhbakbakbhkdkbbkhkdddwpwwmwbbhoh""");
        asciiRepository.save(horse);

        Ascii darkHorse = new Ascii();
        darkHorse.setTitle("Dark Horse");
        darkHorse.setDescription("Horse created with reverse option, so that command palette is reversed");
        darkHorse.setAsciiText("""
                ::::::,,:;::;!l;:::;;;:::::;;;;IlIII;;;;;;II;;;;I;;;III;II!lIl<I!lI!i>!llIIIl>l;
                :::::::;;;;;;lli::::;;;;;;IIIlI;lIII;;I;;;Il!!IIIllIlIl!lll!l!iil!>llIlIIlllIlIl
                ::::::::;;:lll;;:::::;;;;;lI;;;IIl!!lIIIlllil!!il!!!i!!ll!!!i!lI!-]illIIllllI!II
                :;::;;;I;;:::;;;;:;;<I;II;lIlIIIlll!illlll!!!ii!!i>iilllIlI!!Il!_llIli!!lll!III;
                ;;;;;I;I;;;;:;;;;!!IIIl!ll!~<;IlllIIlI!!Illll!!l!!!!i!iil!!!!!i?~l!lli!l!ll!lII;
                ;;I;;I;II;;;;II;;l~iI!<i~!l!!;I;Il;;II;;Illl!!l!!lI!lIli!i!l!l!-lllillll!]]-l>iI
                II;;;III;I;;:i~<ll>+<~!_IlI;;IilI;;I>~<Il!>!>illlI;Il{(}|!llli!>!i<+ii!}_<+}_~[+
                I;;III;III;;;i>l><-i>;;!l;>;;lI!lilI;;III!lIl!ll!rZw0ddoO+ll!lI!!li!l!i><i!!Ili~
                l;;;;I;;;:;;!!!lI;lIl::;;:I;Il!!l;;;;I;;I!Ill-tCqMMoOvqUYh~lI!lli!lIlIlli><<lll!
                I;:;II;;I;;iII;I;;;II:::;;I;Il;III;;;IIIlIll{Z*M*#apZfzcJLY>IllIIllIIIl<-!!lll!l
                ;;;;IIIIIliIl;;;;;;;::::;I;:<?{{[-i:;;;II!+u***##obbw/>?fXfrIlI;I;III;I!<iIIl>>i
                ;;;;!!!llilIII;;;;:>\\nrxjrLhWMMWMM&#odpqqkWW#M#ahkdZQ}IIi[~+III;IIIIIIIi<illllli
                ;I;Ill!l!Ill;;I;]nUwwmCUX***##**oaha*#*#oo**o*aahahOvlII_]lllIlII;III!Ili>ill>>i
                IlIIllll!llllIl/pUrffrt\\cpkhdddppbkhaaaahkkpdbbbkahZL~l!ii!lIlIl;;Illl;lli>!ii~<
                Il!!ll!il!ll!!fdQzrjrfff))cCwwwdLnQmqwqqppq0ZdbpqmQJU-!lIiIIIlI!IIIII;ll!!ii!i<>
                Il>!IliillIixLwLzvr|xX\\<i!+}xzYY/i-1/rvXXYJXuZmqkz/xv_lIl<i!lII!ll;llll!!!iii>!<
                li!llil!iil!(LUn{<l<]ii~+>>+!fUx~;;Il!i>>>>>i[|uCbpCxvn\\><>>!ll>llllllll!Ilii>i!
                !IlII!l!li!ll}_!III>><i>i!!i;fXx!IIIlII;;Ill!l!l!<]LUI~r1l<iii!!!l!!llIIIlll>>!>
                llIIl!lllllIIIIlIl>ii!!i!lII!rr|({_I;Ill!!l!!l;l;~x/l;I{z~llillIIllllIllIIIIl!I!
                lIlIIlllIIll!llIIIl>il!!lIl;I</1;>{\\1iIlIiIl!lli1/}I;I!)j~lIIIIIIIII;;I;IIIIIIII
                i!!!>iii!!!!i>!iii>i>>>>i>iiii~/)!!~+ill!iii!!lllI;IIII;<;;;;;;;I;I;;;;II:;;;III
                [[]{+<>>><><~<+<<<<~<>~_<>i~>i>~(}+!i!i>i!ii!i>iii!i!ii!!>>i!!i!iil!i>iii><><i>>
                qZ0CXczx/1)()(}_~+<+<<>~><_~>!<>><>i!!i!>i!>!llIIlIllllIl!lllll!!l!!i!ii>>ii!<>>
                ~<+_~__}{{)tjtf||1[?-]][?[}({}\\/YYXzvzcvcvftf[++>>>iiiiii!ii>>i>i>><>ii~>><>i>!!
                !!iiil!>>>>+~+_~~<ii<_++<<>+<>>+_]]}]{1[}]})|)[?~~_<+_<+_~+-+__+~+---[?[[}[__~>~""");
        asciiRepository.save(darkHorse);

        System.out.println(horse.getAsciiText());
        System.out.println(darkHorse.getAsciiText());
    }
}
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
............,,,,...,,,......,,,,,,,,,,.,,,,,.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
...........,.,,,.....,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
........,,.,,,,,.....,.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,--,,,,,,,,,,,,,
.....,.,,,...,,...,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,-,,,,,,,,,,,,,,,
.,,.,,,,,,,,.,,.,,,,,,,,,,,-,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,--,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,.,-,,,,,-,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,-,,,,,,,,,---,,,,
,,,,,,,,,,,,.,--,,,---,-,,,.,,,,,,,,,--,,,,,,,,,,,,,,___:,,,,,,,,,--,,,_-,-_--_-
,,,,,,.,,,.,.,,,,,-,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*cccxx#c-,,,,,,,,,,,,,,-,,,,,,-
,,,,,,,,,..,,,,,,,,,,..,..,,,,,,,,,,,,,,,,,,,-:]x###c*x]]x-,,,,,,,,,,,,,,,-,,,,,
,..,,,.,,,,,,,.,,,,,,....,,,,,,,,,,.,,,,,,,,_c#####xc:]*]]],,,,,,,,,,,,,-,,,,,,,
,,,,,,,,,,,,,,.,.,,,.....,,.--___-,...,,,,-*######xxc:,-:]:*,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,..,.,:***:*]x#########xxxcx######xxxcc_,,,_--,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,-*]ccc]]]########xx###########x#xxxc*,,,--,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,:x]*:::::*xxxxxxxxxxx##x#xxxxxxxxxxxc]-,,,,,,,,,,,,,,,,,,,,,,,,--
,,,,,,,,,,,,,,:xc**:::::__*]cccx]*ccxcxxxxcccxxxccc]]-,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,*]c]]**:*]:,,,-_**]]:,-_:**]]]]]*ccxx]:**-,,,-,,,,,,,,,,,,,,,,,,,,,-
,,,,,,,,,,,,_]]*_-,-_,,--,,-,:]*-,,,,,,,,,,,,_:*]xx]***:,-,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,_-,,,,,,,,,,,,,,:]*,,,,,,,,,,,,,,,,,-_]],-*_,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*::__-,,,,,,,,,,,,,,-*:,,,_*-,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,:_,,_:_,,,,,,,,,,,_:_,.,,_:-,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,-:_,,--,,,,,,,,,,,,,,,,,,.,,,.,,,,,,,,,.,,,.,,,,,,
__-_-,,,,,,----,-,--,,--,,,-,,,-__-,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
xcc]]***:______-----,,,-,,--,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
-------____:::::___----_-_____::]]]]******:::_--,,,,,,,,,,,,,,,,,,,,,,,-,,,,,,,,
,,,,,,,,,,,------,,,,---,,,-,,,----_-____-__:__----,-----------------_-____---,-""");
        asciiRepository.save(horse);

        Ascii darkHorse = new Ascii();
        darkHorse.setTitle("Dark Horse");
        darkHorse.setDescription("Horse created with reverse option, so that command palette is reversed");
        darkHorse.setAsciiText("""
&&&&&&&&&&&&####&&&###&&&&&&##########&#####&###################################
&&&&&&&&&&&#&###&&&&&###########################################################
&&&&&&&&##&#####&&&&&#&##########################################xx#############
&&&&&#&###&&&##&&&##############################################x###############
&##&########&##&###########x###################################xx###############
################&#x#####x######################################x#########xxx####
############&#xx###xxx#x###&#########xx##############ccc]#########xx###cx#xcxxcx
######&###&#&#####x##############################*___--,_x##############x######x
#########&&##########&&#&&###################x]:-,,,_*-::-x###############x#####
#&&###&#######&######&&&&##########&########c_,,,,,-_]:*:::#############x#######
##############&#&###&&&&&##&xxcccx#&&&####x*,,,,,,--_]#x]:]*####################
###############&&#&#]***]*:-,,,,,,,,,---_-,,,,,,---__c###cxx####################
################x*:___:::,,,,,,,,--,,,,,,,,,,,-,---_*###xx######################
###############]-:*]]]]]*-----------,,-,-----------_:x########################xx
##############]-_**]]]]]cc*:___-:*__-_----___---___::x##########################
############*:_::**]*:]###xc**::]#xc]**:::::*__--:]**x###x#####################x
############c::*cx#xc##xx##x#]:*x############c]*:--:***]#x######################
#############cx##############]:*#################xc::#x*c#######################
#############################*]]ccx##############x*]###c*x######################
##############################]c##c]c###########c]c#&##c]x######################
##############################x]c##xx##################&###&#########&###&######
ccxcx######xxxx#x#xx##xx###x###xccx#############################################
-__::***]ccccccxxxxx###x##xx####################################################
xxxxxxxcccc]]]]]cccxxxxcxccccc]]::::******]]]cxx#######################x########
###########xxxxxx####xxx###x###xxxxcxccccxcc]ccxxxx#xxxxxxxxxxxxxxxxxcxccccxxx#x""");
        asciiRepository.save(darkHorse);

        System.out.println(horse.getAsciiText());
        System.out.println(darkHorse.getAsciiText());
    }
}
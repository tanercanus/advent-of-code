package com.tanerus.adventofcode.advent2020.day9;

public class Input {
    public static Long[] initializeValues() {

        Long[] inputArray = {
                /*35l,
                20l,
                15l,
                25l,
                47l,
                40l,
                62l,
                55l,
                65l,
                95l,
                102l,
                117l,
                150l,
                182l,
                127l,
                219l,
                299l,
                277l,
                309l,
                576l*/

                37l,
                7l,
                16l,
                34l,
                48l,
                24l,
                5l,
                40l,
                30l,
                35l,
                2l,
                45l,
                19l,
                33l,
                36l,
                49l,
                32l,
                1l,
                44l,
                21l,
                25l,
                3l,
                11l,
                38l,
                15l,
                4l,
                6l,
                7l,
                8l,
                16l,
                9l,
                10l,
                5l,
                12l,
                13l,
                17l,
                14l,
                35l,
                18l,
                19l,
                20l,
                23l,
                36l,
                53l,
                22l,
                21l,
                41l,
                28l,
                11l,
                24l,
                15l,
                25l,
                26l,
                27l,
                29l,
                64l,
                50l,
                31l,
                30l,
                34l,
                32l,
                44l,
                33l,
                47l,
                74l,
                35l,
                66l,
                37l,
                36l,
                38l,
                45l,
                39l,
                40l,
                41l,
                42l,
                57l,
                51l,
                55l,
                68l,
                70l,
                71l,
                72l,
                61l,
                88l,
                65l,
                75l,
                140l,
                77l,
                73l,
                82l,
                110l,
                81l,
                74l,
                116l,
                86l,
                80l,
                112l,
                83l,
                92l,
                128l,
                141l,
                106l,
                120l,
                146l,
                126l,
                147l,
                133l,
                134l,
                138l,
                139l,
                156l,
                209l,
                162l,
                160l,
                154l,
                155l,
                233l,
                216l,
                163l,
                313l,
                298l,
                273l,
                189l,
                198l,
                226l,
                253l,
                232l,
                265l,
                259l,
                260l,
                316l,
                267l,
                272l,
                277l,
                449l,
                428l,
                314l,
                309l,
                471l,
                318l,
                379l,
                430l,
                458l,
                387l,
                683l,
                475l,
                415l,
                421l,
                486l,
                525l,
                544l,
                575l,
                532l,
                519l,
                632l,
                539l,
                590l,
                739l,
                586l,
                623l,
                627l,
                688l,
                696l,
                697l,
                804l,
                1072l,
                1119l,
                940l,
                808l,
                896l,
                836l,
                990l,
                907l,
                1107l,
                1436l,
                1114l,
                1129l,
                1051l,
                1058l,
                1754l,
                1385l,
                1644l,
                1459l,
                1250l,
                2686l,
                1324l,
                2442l,
                1504l,
                1501l,
                1612l,
                1704l,
                1915l,
                1715l,
                1732l,
                1826l,
                1897l,
                2048l,
                2431l,
                2109l,
                3004l,
                2165l,
                2825l,
                2301l,
                3039l,
                2862l,
                3145l,
                2574l,
                2709l,
                2751l,
                3447l,
                4043l,
                3005l,
                4198l,
                3113l,
                3612l,
                4910l,
                3629l,
                3541l,
                4306l,
                4157l,
                4466l,
                4349l,
                4274l,
                5113l,
                5027l,
                5446l,
                6186l,
                7889l,
                8522l,
                5436l,
                5854l,
                5283l,
                5864l,
                6292l,
                6118l,
                6546l,
                6617l,
                6742l,
                6654l,
                7241l,
                7170l,
                7698l,
                8431l,
                11231l,
                8506l,
                8623l,
                9301l,
                9387l,
                10140l,
                10310l,
                12518l,
                11137l,
                10719l,
                11147l,
                11290l,
                11401l,
                11575l,
                12156l,
                12410l,
                12664l,
                16757l,
                13271l,
                13396l,
                19611l,
                14411l,
                14868l,
                17129l,
                16937l,
                29793l,
                17807l,
                17924l,
                18688l,
                27532l,
                23665l,
                21029l,
                21866l,
                23954l,
                22009l,
                22976l,
                30217l,
                34022l,
                25986l,
                27807l,
                29601l,
                30400l,
                26667l,
                27682l,
                28264l,
                40602l,
                29279l,
                31805l,
                34066l,
                41472l,
                45606l,
                41589l,
                47696l,
                48711l,
                55214l,
                43038l,
                57543l,
                69154l,
                45963l,
                77223l,
                66588l,
                68866l,
                55265l,
                115299l,
                58207l,
                54349l,
                95816l,
                68284l,
                62330l,
                115750l,
                61084l,
                100312l,
                90012l,
                116995l,
                100820l,
                84627l,
                139841l,
                94674l,
                89001l,
                97387l,
                98303l,
                190490l,
                178080l,
                109614l,
                112556l,
                113472l,
                115433l,
                116349l,
                225364l,
                116679l,
                122633l,
                194241l,
                123414l,
                145711l,
                158471l,
                150085l,
                173628l,
                268085l,
                179301l,
                198099l,
                182014l,
                183675l,
                186388l,
                391499l,
                207001l,
                207917l,
                222170l,
                223086l,
                229235l,
                323350l,
                228905l,
                530351l,
                233028l,
                239312l,
                262390l,
                304647l,
                308556l,
                389397l,
                295796l,
                344859l,
                415293l,
                352929l,
                380113l,
                430087l,
                405100l,
                365689l,
                370063l,
                393389l,
                545520l,
                431003l,
                530726l,
                445256l,
                456114l,
                462263l,
                533552l,
                524701l,
                472340l,
                846296l,
                535108l,
                674245l,
                763452l,
                604352l,
                640655l,
                758059l,
                697788l,
                718618l,
                733042l,
                1129053l,
                759078l,
                838645l,
                876259l,
                824392l,
                918090l,
                887117l,
                893266l,
                907519l,
                901370l,
                1591316l,
                934603l,
                1469711l,
                1359500l,
                1742482l,
                1139460l,
                1175763l,
                1245007l,
                1302140l,
                1362411l,
                1338443l,
                1571687l,
                1416406l,
                1963852l,
                1557434l,
                1583470l,
                1597723l,
                1663037l,
                1769525l,
                2032726l,
                1780383l,
                1827869l,
                3212193l,
                1808889l,
                2351009l,
                2908044l,
                2538174l,
                2384467l,
                3385303l,
                3352070l,
                2315223l,
                2420770l,
                2547147l,
                2640583l,
                2778817l,
                3886910l,
                2973840l,
                2999876l,
                4336251l,
                3140904l,
                3181193l,
                5009062l,
                4606686l,
                4229659l,
                5601963l,
                3589272l,
                3636758l,
                4124112l,
                4159898l,
                4666232l,
                4699690l,
                4735993l,
                4805237l,
                6183905l,
                4862370l,
                4955806l,
                4967917l,
                5187730l,
                5419400l,
                7370563l,
                5973716l,
                6589148l,
                7226030l,
                6322097l,
                10580402l,
                6817951l,
                7713384l,
                11509827l,
                7749170l,
                7760870l,
                7796656l,
                8824488l,
                8860105l,
                8895891l,
                10281770l,
                12554407l,
                15536208l,
                9667607l,
                16645061l,
                13548127l,
                9923723l,
                13692660l,
                10607130l,
                22222014l,
                12295813l,
                14531335l,
                12911245l,
                20092469l,
                19476293l,
                14567121l,
                15678056l,
                15462554l,
                15510040l,
                18356300l,
                30972594l,
                19141875l,
                34623804l,
                17755996l,
                18563498l,
                19591330l,
                25386277l,
                20274737l,
                20530853l,
                27240787l,
                22902943l,
                22219536l,
                30198460l,
                30667241l,
                25207058l,
                26827148l,
                27442580l,
                43742577l,
                32323117l,
                30029675l,
                34158451l,
                33218550l,
                33266036l,
                33866340l,
                36112296l,
                37347326l,
                36319494l,
                52721949l,
                44977607l,
                38154828l,
                39866067l,
                40805590l,
                42494273l,
                43433796l,
                68014567l,
                45122479l,
                55485572l,
                58425608l,
                52034206l,
                52649638l,
                76652724l,
                57472255l,
                128686930l,
                95216222l,
                73666820l,
                66484586l,
                67084890l,
                69378332l,
                91338595l,
                72431790l,
                137710495l,
                74474322l,
                78020895l,
                127917362l,
                84988546l,
                84239386l,
                83299863l,
                85928069l,
                111607065l,
                132899930l,
                135078332l,
                186342970l,
                104683844l,
                109506461l,
                110121893l,
                123956841l,
                124557145l,
                161700808l,
                256917030l,
                186081387l,
                146906112l,
                136463222l,
                141810122l,
                150452685l,
                158713708l,
                207374252l,
                157774185l,
                167539249l,
                168288409l,
                193421756l,
                169227932l,
                269381250l,
                197535134l,
                229240989l,
                214190305l,
                244584793l,
                214805737l,
                219628354l,
                177777905l,
                246585115l,
                286915907l,
                261020367l,
                278273344l,
                311038054l,
                335827658l,
                283369334l,
                292262807l,
                360961005l,
                396780238l,
                437669659l,
                325313434l,
                365074383l,
                448869343l,
                361710165l,
                347005837l,
                608295280l,
                392583642l,
                422362698l,
                391968210l,
                397406259l,
                424363020l,
                456051249l,
                503091339l,
                461147239l,
                893720908l,
                561642678l,
                589311398l,
                570536151l,
                675337544l,
                619196992l,
                575632141l,
                639268644l,
                707966842l,
                708716002l,
                672319271l,
                687023599l,
                821769279l,
                754293807l,
                738974047l,
                739589479l,
                1483032306l,
                1031683390l,
                789374469l,
                1036779380l,
                1233961949l,
                880414269l,
                1133466510l,
                964238578l,
                1022789917l,
                1809594090l,
                2272406775l,
                1164943539l,
                1209804795l,
                1214900785l,
                1194829133l,
                1247951412l,
                1461693740l,
                1359342870l,
                1791073187l,
                1411908750l,
                1651262177l,
                1478563526l,
                1493883286l,
                1821057859l,
                1776368859l,
                1753613047l,
                1954318008l,
                2156256427l,
                1844652847l,
                1903204186l,
                3010605047l,
                1987028495l,
                2129182117l,
                2187733456l,
                3196833290l,
                3284956473l,
                2359772672l,
                2404633928l,
                2409729918l,
                2442780545l,
                2607294282l,
                2771251620l,
                2837906396l,
                3920255304l,
                2905792036l,
                3747857033l,
                3323216373l,
                3247496333l,
                4630514001l,
                4802553217l,
                3598265894l,
                4510498468l,
                4307838114l,
                3831681342l,
                4174761951l,
                4116210612l,
                7346122927l,
                4316915573l,
                4597463374l,
                5652130261l,
                4847414473l,
                4764406600l,
                6236315270l,
                5050074827l,
                5214032165l,
                7618666093l,
                6369517514l,
                8918763829l,
                6153288369l,
                6229008409l,
                6570712706l,
                6921482267l,
                7422258284l,
                7714476506l,
                7906104008l,
                7915181467l,
                8148596915l,
                11663038500l,
                8679095815l,
                8290972563l,
                8433126185l,
                8914378947l,
                9081322173l,
                11168176080l,
                9611821073l,
                13362629080l,
                9814481427l,
                10264106992l,
                11203363196l,
                12382296778l,
                14284698981l,
                12522805883l,
                12724001075l,
                16834819698l,
                23726169079l,
                13492194973l,
                17995701120l,
                15136734790l,
                15620580514l,
                15821285475l,
                22196778205l,
                16439569478l,
                16724098748l,
                23306676400l,
                17514448358l,
                17347505132l,
                18728860374l,
                18693143246l,
                19426302500l,
                19875928065l,
                21467470188l,
                21017844623l,
                32651183148l,
                24905102661l,
                28002877292l,
                31949108383l,
                31860833538l,
                40450267827l,
                29313480448l,
                28628929763l,
                38018063680l,
                33616281634l,
                34238547106l,
                31441865989l,
                59143411073l,
                33163668226l,
                36040648378l,
                34071603880l,
                48956314347l,
                36243308732l,
                60070795752l,
                49020721915l,
                55083751822l,
                39302230565l,
                40893772688l,
                70744096554l,
                45922947284l,
                52907979953l,
                54218583109l,
                59951985675l,
                63385084328l,
                57942410211l,
                62477148674l,
                93101815502l,
                61792597989l,
                65680413095l,
                64605534215l,
                93919014663l,
                67235272106l,
                69204316604l,
                69406976958l,
                70112252258l,
                70314912612l,
                75545539297l,
                110813319904l,
                88322952480l,
                80196003253l,
                150800101154l,
                118824117324l,
                110098089292l,
                98830927237l,
                100141530393l,
                112160993320l,
                114170568784l,
                129027870095l,
                157729929438l,
                199136272384l,
                124269746663l,
                186062344652l,
                127473011084l,
                130285947310l,
                133809850819l,
                136439588710l,
                183374885388l,
                138611293562l,
                139519229216l,
                250332549120l,
                194366572037l,
                204465749916l,
                316348291962l,
                168518955733l,
                210481950563l,
                314563839208l,
                232640778056l,
                238752823955l,
                198972457630l,
                212302523713l,
                250610157494l,
                438833585871l,
                251742757747l,
                266992240300l,
                266084304646l,
                705825826171l,
                257758958394l,
                270249439529l,
                264095798129l,
                272421144381l,
                404848522600l,
                441133843782l,
                278130522778l,
                308038184949l,
                362885527770l,
                367491413363l,
                379000906296l,
                380821479446l,
                502352915241l,
                409454408193l,
                411274981343l,
                431613235686l,
                437725281585l,
                478386828359l,
                484723668094l,
                633575718009l,
                509501716141l,
                703809586231l,
                523843263040l,
                852408825125l,
                521854756523l,
                528008397923l,
                534345237658l,
                766448713370l,
                653242623827l,
                778766394706l,
                586168707727l,
                641016050548l,
                688859664395l,
                730376941133l,
                869844328604l,
                889661809702l,
                790275887639l,
                820729389536l,
                841067643879l,
                842888217029l,
                955456498726l,
                1110011970767l,
                1070892375821l,
                1573265158162l,
                1227184758275l,
                1031356472664l,
                1056199994181l,
                1045698019563l,
                1252231697656l,
                1162870807071l,
                1169024448471l,
                1264722178791l,
                1479135552034l,
                1239411331554l,
                1275028372122l,
                1427236351606l,
                1510860379152l,
                2589147522801l,
                2054998066430l,
                2180904346588l,
                1611005277175l,
                1631343531518l,
                1776185888262l,
                1683955860908l,
                1798344715755l,
                2077054492227l,
                2087556466845l,
                2116590395384l,
                3761010353135l,
                2101898013744l,
                2194227279735l,
                2208568826634l,
                2402282138625l,
                3878083902006l,
                2331895255542l,
                4408949747769l,
                3458949458526l,
                2514439703676l,
                2666647683160l,
                2702264723728l,
                2938096730758l,
                3121865656327l,
                3460141749170l,
                3242348808693l,
                4325159222018l,
                5090292990044l,
                3315299392426l,
                3482300576663l,
                5330434482961l,
                3992571995490l,
                4631030099060l,
                6603177027504l,
                4218488409128l,
                4296125293479l,
                6148948259823l,
                4402796106369l,
                6364214465020l,
                5884582715288l,
                4846334959218l,
                4998542938702l,
                5181087386836l,
                6017564116154l,
                5216704427404l,
                9033826205429l,
                5640361454486l,
                8698921399848l,
                6582007405497l,
                6557648201119l,
                9936627949262l,
                7718095498795l,
                9199882107714l,
                7307871387916l,
                9961464582021l,
                8838906954708l,
                10215247366106l,
                9477365058278l,
                8514613702607l,
                20151875315368l,
                9142460252697l,
                9401339045071l,
                9583883493205l,
                15142551968857l,
                19249073571535l,
                11234268543558l,
                10179630325538l,
                10397791814240l,
                15983346450568l,
                26198593816674l,
                12198009655605l,
                12948232842402l,
                15781889513211l,
                15724467658194l,
                13865519589035l,
                15025966886711l,
                17679560080816l,
                15822485090523l,
                16146778342624l,
                25939715024300l,
                30924441482068l,
                24924349765908l,
                17657073955304l,
                18098497195812l,
                18543799297768l,
                28913828624374l,
                18985222538276l,
                19763513818743l,
                20577422139778l,
                31707814108762l,
                21413898869096l,
                34325688810979l,
                27922477313799l,
                25146242498007l,
                38256982220594l,
                32409318886803l,
                31545079669851l,
                28891486475746l,
                53838178390282l,
                29688004679558l,
                30848451977234l,
                39957698166864l,
                50472467153603l,
                33803852297928l,
                68570964349415l,
                57805315100120l,
                37083719734088l,
                35755571151116l,
                36642296493580l,
                63239517435353l,
                38748736357019l,
                66735007697782l,
                44909756316750l,
                79219213969216l,
                46560141367103l,
                49336376182895l,
                57555561384810l,
                64647057626862l,
                78706434523883l,
                115861510462796l,
                62097323566361l,
                114974785120332l,
                78227862658641l,
                60536456656792l,
                66771724413646l

        };

        return inputArray;

    }
}

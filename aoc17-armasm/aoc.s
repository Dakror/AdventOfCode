	.arch armv7-a
	.eabi_attribute 28, 1	@ Tag_ABI_VFP_args
	.eabi_attribute 20, 1	@ Tag_ABI_FP_denormal
	.eabi_attribute 21, 1	@ Tag_ABI_FP_exceptions
	.eabi_attribute 23, 3	@ Tag_ABI_FP_number_model
	.eabi_attribute 24, 1	@ Tag_ABI_align8_needed
	.eabi_attribute 25, 1	@ Tag_ABI_align8_preserved
	.eabi_attribute 26, 2	@ Tag_ABI_enum_size
	.eabi_attribute 30, 6	@ Tag_ABI_optimization_goals
	.eabi_attribute 34, 1	@ Tag_CPU_unaligned_access
	.eabi_attribute 18, 4	@ Tag_ABI_PCS_wchar_t
	.file	"aoc.c"
@ GNU C11 (GCC) version 7.1.1 20170516 (armv7l-unknown-linux-gnueabihf)
@	compiled by GNU C version 7.1.1 20170516, GMP version 6.1.2, MPFR version 3.1.5-p2, MPC version 1.0.3, isl version isl-0.18-GMP

@ GGC heuristics: --param ggc-min-expand=92 --param ggc-min-heapsize=117779
@ options passed:  aoc.c -march=armv7-a -mfloat-abi=hard -mfpu=vfpv3-d16
@ -mtls-dialect=gnu -fverbose-asm
@ options enabled:  -faggressive-loop-optimizations -fauto-inc-dec
@ -fchkp-check-incomplete-type -fchkp-check-read -fchkp-check-write
@ -fchkp-instrument-calls -fchkp-narrow-bounds -fchkp-optimize
@ -fchkp-store-bounds -fchkp-use-static-bounds
@ -fchkp-use-static-const-bounds -fchkp-use-wrappers -fcommon
@ -fdelete-null-pointer-checks -fdwarf2-cfi-asm -fearly-inlining
@ -feliminate-unused-debug-types -ffp-int-builtin-inexact -ffunction-cse
@ -fgcse-lm -fgnu-runtime -fgnu-unique -fident -finline-atomics
@ -fira-hoist-pressure -fira-share-save-slots -fira-share-spill-slots
@ -fivopts -fkeep-static-consts -fleading-underscore -flifetime-dse
@ -flto-odr-type-merging -fmath-errno -fmerge-debug-strings -fpeephole
@ -fplt -fprefetch-loop-arrays -freg-struct-return
@ -fsched-critical-path-heuristic -fsched-dep-count-heuristic
@ -fsched-group-heuristic -fsched-interblock -fsched-last-insn-heuristic
@ -fsched-rank-heuristic -fsched-spec -fsched-spec-insn-heuristic
@ -fsched-stalled-insns-dep -fsemantic-interposition -fshow-column
@ -fshrink-wrap-separate -fsigned-zeros -fsplit-ivs-in-unroller
@ -fssa-backprop -fstdarg-opt -fstrict-volatile-bitfields -fsync-libcalls
@ -ftrapping-math -ftree-cselim -ftree-forwprop -ftree-loop-if-convert
@ -ftree-loop-im -ftree-loop-ivcanon -ftree-loop-optimize
@ -ftree-parallelize-loops= -ftree-phiprop -ftree-reassoc -ftree-scev-cprop
@ -funit-at-a-time -fverbose-asm -fzero-initialized-in-bss -marm -mglibc
@ -mlittle-endian -mpic-data-is-text-relative -msched-prolog
@ -munaligned-access -mvectorize-with-neon-quad

	.section	.rodata
	.align	2
.LC1:
	.ascii	"567298753335395619962968394156452864626256711743346"
	.ascii	"154774779392832295864677983248468917415191826155168"
	.ascii	"922175616559889842873678219451162782935571849372396"
	.ascii	"132327213645251798747135138188194688352824861161125"
	.ascii	"865619981299863268266874968358851536294699441585233"
	.ascii	"719671847621916212497883653734892459195718882792975"
	.ascii	"341788494213384466463696974254771722825573995931635"
	.ascii	"185273159829252983788599278181513187618357846113579"
	.ascii	"131528713524354165985373434337661841995277616554482"
	.ascii	"971767698889768414132813834838288269967295786614652"
	.ascii	"475987923655593572365532674371354293169347782428928"
	.ascii	"354246863952227164325721283324816539195768622631124"
	.ascii	"651797831925397727666382547914432115571286694625599"
	.ascii	"263487615882285538233145264995328378886324819233824"
	.ascii	"594396626919742147455577913516863726327957984288534"
	.ascii	"715228727567981157659437653522616789498122686622298"
	.ascii	"752241578524487588255641495672497634162712355721483"
	.ascii	"787387272361839552973534927324168654828754976399365"
	.ascii	"337953944543531969882546528981766329443645819486727"
	.ascii	"862397874598179928378923755524272829133753849861692"
	.ascii	"981726821169864923664612789998283952378483775286345"
	.ascii	"881996548514981295912188477184995472325936577815178"
	.ascii	"871994188812861855245587936991951131973552562119818"
	.ascii	"563434253884846246183333291798629744538851571746316"
	.ascii	"851512373245557614344745483584956575777332536746976"
	.ascii	"338375767793874831996897131226787161995165726791381"
	.ascii	"724248555977158216729579425944125628416835629278556"
	.ascii	"885852718412223126246519361212796168551391383527482"
	.ascii	"389259692378661329974734725925482353126218532827436"
	.ascii	"752926586885651218513532965263593837326675996411986"
	.ascii	"349479822224553675879238978981864665528785617353447"
	.ascii	"955136411597681145967712359274737529631366725341369"
	.ascii	"882365521825416819616288343738971816774387121637316"
	.ascii	"486542645879423949622485897169487715959121577293839"
	.ascii	"682743528973416585397526752129157443656719347381424"
	.ascii	"798187773522337696412535999255588513781664738213959"
	.ascii	"664685641742461784798185553291487225168671939434176"
	.ascii	"432439525455678227742632633144198173755726258176241"
	.ascii	"254484968947228164583595766721738433443539157298522"
	.ascii	"82865375743"
	.ascii	"888348356934168214196559674561373954656492492565728"
	.ascii	"66516984318344482684936625486311718525523265165\000"
	.align	2
.LC2:
	.ascii	"day1_a: %d\012\000"
	.align	2
.LC3:
	.ascii	"day1_b: %d\012\000"
	.text
	.align	2
	.global	day1
	.syntax unified
	.arm
	.fpu vfpv3-d16
	.type	day1, %function
day1:
	@ args = 0, pretend = 0, frame = 16
	@ frame_needed = 1, uses_anonymous_args = 0
	push	{fp, lr}	@
	add	fp, sp, #4	@,,
	sub	sp, sp, #16	@,,
@ aoc.c:10: 	char* input = "5672987533353956199629683941564528646262567117433461547747793928322958646779832484689174151918261551689221756165598898428736782194511627829355718493723961323272136452517987471351381881946883528248611611258656199812998632682668749683588515362946994415852337196718476219162124978836537348924591957188827929753417884942133844664636969742547717228255739959316351852731598292529837885992781815131876183578461135791315287135243541659853734343376618419952776165544829717676988897684141328138348382882699672957866146524759879236555935723655326743713542931693477824289283542468639522271643257212833248165391957686226311246517978319253977276663825479144321155712866946255992634876158822855382331452649953283788863248192338245943966269197421474555779135168637263279579842885347152287275679811576594376535226167894981226866222987522415785244875882556414956724976341627123557214837873872723618395529735349273241686548287549763993653379539445435319698825465289817663294436458194867278623978745981799283789237555242728291337538498616929817268211698649236646127899982839523784837752863458819965485149812959121884771849954723259365778151788719941888128618552455879369919511319735525621198185634342538848462461833332917986297445388515717463168515123732455576143447454835849565757773325367469763383757677938748319968971312267871619951657267913817242485559771582167295794259441256284168356292785568858527184122231262465193612127961685513913835274823892596923786613299747347259254823531262185328274367529265868856512185135329652635938373266759964119863494798222245536758792389789818646655287856173534479551364115976811459677123592747375296313667253413698823655218254168196162883437389718167743871216373164865426458794239496224858971694877159591215772938396827435289734165853975267521291574436567193473814247981877735223376964125359992555885137816647382139596646856417424617847981855532914872251686719394341764324395254556782277426326331441981737557262581762412544849689472281645835957667217384334435391572985228286537574388834835693416821419655967456137395465649249256572866516984318344482684936625486311718525523265165";
	movw	r3, #:lower16:.LC1	@ tmp110,
	movt	r3, #:upper16:.LC1	@ tmp110,
	str	r3, [fp, #-8]	@ tmp110, input
@ aoc.c:12: 	int a_ret = day1_a(input);
	ldr	r0, [fp, #-8]	@, input
	bl	day1_a	@
	str	r0, [fp, #-12]	@, a_ret
@ aoc.c:14: 	printf("day1_a: %d\n", a_ret);
	ldr	r1, [fp, #-12]	@, a_ret
	movw	r0, #:lower16:.LC2	@,
	movt	r0, #:upper16:.LC2	@,
	bl	printf	@
@ aoc.c:16: 	int b_ret = day1_b(input);
	ldr	r0, [fp, #-8]	@, input
	bl	day1_b	@
	str	r0, [fp, #-16]	@, b_ret
@ aoc.c:18: 	printf("day1_b: %d\n", b_ret);
	ldr	r1, [fp, #-16]	@, b_ret
	movw	r0, #:lower16:.LC3	@,
	movt	r0, #:upper16:.LC3	@,
	bl	printf	@
@ aoc.c:19: }
	nop
	sub	sp, fp, #4	@,,
	@ sp needed	@
	pop	{fp, pc}	@
	.size	day1, .-day1
	.section	.rodata
	.align	2
.LC4:
	.ascii	"day2_a: %d\012\000"
	.align	2
.LC5:
	.ascii	"day2_b: %d\012\000"
	.align	2
.LC0:
	.short	790
	.short	99
	.short	345
	.short	1080
	.short	32
	.short	143
	.short	1085
	.short	984
	.short	553
	.short	98
	.short	123
	.short	97
	.short	197
	.short	886
	.short	125
	.short	947
	.short	302
	.short	463
	.short	59
	.short	58
	.short	55
	.short	87
	.short	508
	.short	54
	.short	472
	.short	63
	.short	469
	.short	419
	.short	424
	.short	331
	.short	337
	.short	72
	.short	899
	.short	962
	.short	77
	.short	1127
	.short	62
	.short	530
	.short	78
	.short	880
	.short	129
	.short	1014
	.short	93
	.short	148
	.short	239
	.short	288
	.short	357
	.short	424
	.short	2417
	.short	2755
	.short	254
	.short	3886
	.short	5336
	.short	3655
	.short	5798
	.short	3273
	.short	5016
	.short	178
	.short	270
	.short	6511
	.short	223
	.short	5391
	.short	1342
	.short	2377
	.short	68
	.short	3002
	.short	3307
	.short	166
	.short	275
	.short	1989
	.short	1611
	.short	364
	.short	157
	.short	144
	.short	3771
	.short	1267
	.short	3188
	.short	3149
	.short	156
	.short	3454
	.short	1088
	.short	1261
	.short	21
	.short	1063
	.short	1173
	.short	278
	.short	1164
	.short	207
	.short	237
	.short	1230
	.short	1185
	.short	431
	.short	232
	.short	660
	.short	195
	.short	1246
	.short	49
	.short	1100
	.short	136
	.short	1491
	.short	647
	.short	1486
	.short	112
	.short	1278
	.short	53
	.short	1564
	.short	1147
	.short	1068
	.short	809
	.short	1638
	.short	138
	.short	117
	.short	158
	.short	3216
	.short	1972
	.short	2646
	.short	3181
	.short	785
	.short	2937
	.short	365
	.short	611
	.short	1977
	.short	1199
	.short	2972
	.short	201
	.short	2432
	.short	186
	.short	160
	.short	244
	.short	86
	.short	61
	.short	38
	.short	58
	.short	71
	.short	243
	.short	52
	.short	245
	.short	264
	.short	209
	.short	265
	.short	308
	.short	80
	.short	126
	.short	129
	.short	1317
	.short	792
	.short	74
	.short	111
	.short	1721
	.short	252
	.short	1082
	.short	1881
	.short	1349
	.short	94
	.short	891
	.short	1458
	.short	331
	.short	1691
	.short	89
	.short	1724
	.short	3798
	.short	202
	.short	3140
	.short	3468
	.short	1486
	.short	2073
	.short	3872
	.short	3190
	.short	3481
	.short	3760
	.short	2876
	.short	182
	.short	2772
	.short	226
	.short	3753
	.short	188
	.short	2272
	.short	6876
	.short	6759
	.short	218
	.short	272
	.short	4095
	.short	4712
	.short	6244
	.short	4889
	.short	2037
	.short	234
	.short	223
	.short	6858
	.short	3499
	.short	2358
	.short	439
	.short	792
	.short	230
	.short	886
	.short	824
	.short	762
	.short	895
	.short	99
	.short	799
	.short	94
	.short	110
	.short	747
	.short	635
	.short	91
	.short	406
	.short	89
	.short	157
	.short	2074
	.short	237
	.short	1668
	.short	1961
	.short	170
	.short	2292
	.short	2079
	.short	1371
	.short	1909
	.short	221
	.short	2039
	.short	1022
	.short	193
	.short	2195
	.short	1395
	.short	2123
	.short	8447
	.short	203
	.short	1806
	.short	6777
	.short	278
	.short	2850
	.short	1232
	.short	6369
	.short	398
	.short	235
	.short	212
	.short	992
	.short	7520
	.short	7304
	.short	7852
	.short	520
	.short	3928
	.short	107
	.short	3406
	.short	123
	.short	2111
	.short	2749
	.short	223
	.short	125
	.short	134
	.short	146
	.short	3875
	.short	1357
	.short	508
	.short	1534
	.short	4002
	.short	4417
	.text
	.align	2
	.global	day2
	.syntax unified
	.arm
	.fpu vfpv3-d16
	.type	day2, %function
day2:
	@ args = 0, pretend = 0, frame = 520
	@ frame_needed = 1, uses_anonymous_args = 0
	push	{fp, lr}	@
	add	fp, sp, #4	@,,
	sub	sp, sp, #520	@,,
@ aoc.c:22: 	short input[][16] = {{790,99,345,1080,32,143,1085,984,553,98,123,97,197,886,125,947},
	movw	r3, #:lower16:.LC0	@ tmp110,
	movt	r3, #:upper16:.LC0	@ tmp110,
	sub	r0, fp, #524	@ tmp111,,
	mov	r1, r3	@ tmp112, tmp110
	mov	r3, #512	@ tmp113,
	mov	r2, r3	@, tmp113
	bl	memcpy	@
@ aoc.c:43: 	int a_ret = day2_a(input, 16,16);
	sub	r3, fp, #524	@ tmp115,,
	mov	r2, #16	@,
	mov	r1, #16	@,
	mov	r0, r3	@, tmp115
	bl	day2_a	@
	str	r0, [fp, #-8]	@, a_ret
@ aoc.c:45: 	printf("day2_a: %d\n", a_ret);	
	ldr	r1, [fp, #-8]	@, a_ret
	movw	r0, #:lower16:.LC4	@,
	movt	r0, #:upper16:.LC4	@,
	bl	printf	@
@ aoc.c:47: 	int b_ret = day2_b(input, 16,16);
	sub	r3, fp, #524	@ tmp116,,
	mov	r2, #16	@,
	mov	r1, #16	@,
	mov	r0, r3	@, tmp116
	bl	day2_b	@
	str	r0, [fp, #-12]	@, b_ret
@ aoc.c:49: 	printf("day2_b: %d\n", b_ret);
	ldr	r1, [fp, #-12]	@, b_ret
	movw	r0, #:lower16:.LC5	@,
	movt	r0, #:upper16:.LC5	@,
	bl	printf	@
@ aoc.c:50: }
	nop
	sub	sp, fp, #4	@,,
	@ sp needed	@
	pop	{fp, pc}	@
	.size	day2, .-day2
	.align	2
	.global	main
	.syntax unified
	.arm
	.fpu vfpv3-d16
	.type	main, %function
main:
	@ args = 0, pretend = 0, frame = 0
	@ frame_needed = 1, uses_anonymous_args = 0
	push	{fp, lr}	@
	add	fp, sp, #4	@,,
@ aoc.c:53: 	day2();
	bl	day2	@
@ aoc.c:54: 	return 0;
	mov	r3, #0	@ _3,
@ aoc.c:55: }
	mov	r0, r3	@, <retval>
	pop	{fp, pc}	@
	.size	main, .-main
	.ident	"GCC: (GNU) 7.1.1 20170516"
	.section	.note.GNU-stack,"",%progbits

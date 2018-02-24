package io.jerry.dungeon.util;

import org.bukkit.inventory.ItemStack;

public class ItemsUtil {
	@SuppressWarnings("deprecation")
	public static String GetName(ItemStack i){
		if(i.hasItemMeta() && i.getItemMeta().hasDisplayName()){
			return i.getItemMeta().getDisplayName();
		}

		int itemId = i.getTypeId();
		switch (itemId) {
			case 0: return "空氣";
			case 1:  return "石頭";
			case 2:  return "草";
			case 3:  return "泥土";
			case 4:  return "圓石";
			case 5:  return "木板";
			case 6:  return "樹苗";
			case 7:  return "基岩";
			case 8:  return "水";
			case 9:  return "靜止的水";
			case 10:  return "岩漿";
			case 11:  return "靜止的岩漿";
			case 12:  return "沙子";
			case 13:  return "沙礫";
			case 14:  return "金礦石";
			case 15:  return "鐵礦石";
			case 16:  return "煤礦石";
			case 17:  return "木頭";
			case 18:  return "樹葉";
			case 19:  return "海綿";
			case 20:  return "玻璃";
			case 21:  return "青金石礦石";
			case 22:  return "青金石塊";
			case 23:  return "發射器";
			case 24:  return "沙石";
			case 25:  return "音符盒";
			case 26:  return "床";
			case 27:  return "充能鐵軌";
			case 28:  return "探測鐵軌";
			case 29:  return "粘性活塞";
			case 30:  return "蜘蛛網";
			case 31:  return "草叢";
			case 32:  return "枯死的灌木";
			case 33:  return "活塞";
			case 34:  return "活塞臂";
			case 35:  return "羊毛";
			case 36:  return "由活塞所移動的方塊";
			case 37:  return "蒲公英";
			case 38:  return "玫瑰";
			case 39:  return "粽色蘑菇";
			case 40:  return "紅色蘑菇";
			case 41:  return "金塊";
			case 42:  return "鐵塊";
			case 43:  return "雙台階";
			case 44:  return "台階";
			case 45:  return "磚塊";
			case 46:  return "N";
			case 47:  return "書架";
			case 48:  return "苔石";
			case 49:  return "黑曜石";
			case 50:  return "火把";
			case 51:  return "火";
			case 52:  return "刷怪箱";
			case 53:  return "木樓梯";
			case 54:  return "箱子";
			case 55:  return "紅石線";
			case 56:  return "鑽石礦石";
			case 57:  return "鑽石塊";
			case 58:  return "工作台";
			case 59:  return "小麥種子";
			case 60:  return "耕地";
			case 61:  return "熔爐";
			case 62:  return "燃燒中的熔爐";
			case 63:  return "告示牌";
			case 64:  return "木門";
			case 65:  return "梯子";
			case 66:  return "鐵軌";
			case 67:  return "圓石樓梯";
			case 68:  return "牆上的告示牌";
			case 69:  return "拉杆";
			case 70:  return "石質壓力板";
			case 71:  return "鐵門";
			case 72:  return "木質壓力板";
			case 73:  return "紅石礦石";
			case 74:  return "發光的紅石礦石";
			case 75:  return "紅石火把(關閉)";
			case 76:  return "紅石火把(開啟)";
			case 77:  return "按鈕";
			case 78:  return "雪";
			case 79:  return "冰";
			case 80:  return "雪塊";
			case 81:  return "仙人掌";
			case 82:  return "粘土塊";
			case 83:  return "甘蔗";
			case 84:  return "唱片機";
			case 85:  return "柵欄";
			case 86:  return "南瓜";
			case 87:  return "地獄岩";
			case 88:  return "靈魂沙";
			case 89:  return "螢石";
			case 90:  return "傳送門方塊";
			case 91:  return "南瓜燈";
			case 92:  return "蛋糕";
			case 93:  return "紅石中繼器(關閉)";
			case 94:  return "紅石中繼器(開啟)";
			case 95:  return "上鎖的箱子";
			case 96:  return "活板門";
			case 97:  return "?藏的蠹蟲";
			case 98:  return "石磚";
			case 99:  return "粽色巨型蘑菇";
			case 100:  return "紅色巨型蘑菇";
			case 101:  return "鐵欄杆";
			case 102:  return "玻璃板";
			case 103:  return "西瓜";
			case 104:  return "南瓜梗";
			case 105:  return "西瓜梗";
			case 106:  return "藤蔓";
			case 107:  return "柵欄門";
			case 108:  return "磚樓梯";
			case 109:  return "石磚樓梯";
			case 110:  return "菌絲";
			case 111:  return "睡蓮";
			case 112:  return "地獄磚塊";
			case 113:  return "地獄磚柵欄";
			case 114:  return "地獄磚樓梯";
			case 115:  return "地獄疣";
			case 116:  return "附魔台";
			case 117:  return "釀造台";
			case 118:  return "煉藥鍋";
			case 119:  return "末地傳送門方塊";
			case 120:  return "末地傳送門框架";
			case 121:  return "末地石";
			case 122:  return "龍蛋";
			case 123:  return "紅石燈(關閉狀態)";
			case 124:  return "紅石燈(開啟狀態)";
			case 125:  return "雙木台階";
			case 126:  return "木台階";
			case 127:  return "可可果";
			case 128:  return "沙石樓梯";
			case 129:  return "綠寶石礦石";
			case 130:  return "末影箱";
			case 131:  return "絆線鉤";
			case 132:  return "絆線";
			case 133:  return "綠寶石塊";
			case 134:  return "雲杉木樓梯";
			case 135:  return "樺木樓梯";
			case 136:  return "叢林木樓梯";
			case 137:  return "命令方塊";
			case 138:  return "信標";
			case 139:  return "圓石牆";
			case 140:  return "花盆";
			case 141:  return "胡蘿蔔";
			case 142:  return "馬鈴薯";
			case 143:  return "木質按鈕";
			case 144:  return "頭";
			case 145:  return "鐵砧";
			case 146:  return "陷阱箱";
			case 147:  return "測重壓力板(輕質)";
			case 148:  return "測重壓力板(重質)";
			case 149:  return "紅石比較器(關閉)";
			case 150:  return "紅石比較器(開啟)";
			case 151:  return "陽光感測器";
			case 152:  return "紅石塊";
			case 153:  return "下界石英礦石";
			case 154:  return "漏斗";
			case 155:  return "下界石英塊";
			case 156:  return "下界石英樓梯";
			case 157:  return "激活鐵軌";
			case 158:  return "投擲器";
			case 256:  return "鐵鍬";
			case 257:  return "鐵鎬";
			case 258:  return "鐵斧";
			case 259:  return "打火石";
			case 260:  return "紅蘋果";
			case 261:  return "弓";
			case 262:  return "箭";
			case 263:  return "煤炭";
			case 264:  return "鑽石";
			case 265:  return "鐵錠";
			case 266:  return "金錠";
			case 267:  return "鐵劍";
			case 268:  return "木劍";
			case 269:  return "木鍬";
			case 270:  return "木鎬";
			case 271:  return "木斧";
			case 272:  return "石劍";
			case 273:  return "石鍬";
			case 274:  return "石鎬";
			case 275:  return "石斧";
			case 276:  return "鑽石劍";
			case 277:  return "鑽石鍬";
			case 278:  return "鑽石鎬";
			case 279:  return "鑽石斧";
			case 280:  return "木棍";
			case 281:  return "碗";
			case 282:  return "蘑菇煲";
			case 283:  return "金劍";
			case 284:  return "金鍬";
			case 285:  return "金鎬";
			case 286:  return "金斧";
			case 287:  return "線";
			case 288:  return "羽毛";
			case 289:  return "火藥";
			case 290:  return "木鋤";
			case 291:  return "石鋤";
			case 292:  return "鐵鋤";
			case 293:  return "鑽石鋤";
			case 294:  return "金鋤";
			case 295:  return "小麥種子";
			case 296:  return "小麥";
			case 297:  return "麵包";
			case 298:  return "皮革帽子";
			case 299:  return "皮革外衣";
			case 300:  return "皮革褲子";
			case 301:  return "皮革靴";
			case 302:  return "鏈甲頭盔";
			case 303:  return "鏈甲胸甲";
			case 304:  return "鏈甲護腿";
			case 305:  return "鏈甲靴子";
			case 306:  return "鐵頭盔";
			case 307:  return "鐵胸甲";
			case 308:  return "鐵護腿";
			case 309:  return "鐵靴子";
			case 310:  return "鑽石頭盔";
			case 311:  return "鑽石胸甲";
			case 312:  return "鑽石護腿";
			case 313:  return "鑽石靴子";
			case 314:  return "金頭盔";
			case 315:  return "金胸甲";
			case 316:  return "金護腿";
			case 317:  return "金靴子";
			case 318:  return "燧石";
			case 319:  return "生豬排";
			case 320:  return "熟豬排";
			case 321:  return "畫";
			case 322:  return "金蘋果";
			case 323:  return "告示牌";
			case 324:  return "木門";
			case 325:  return "桶";
			case 326:  return "水桶";
			case 327:  return "岩漿桶";
			case 328:  return "礦車";
			case 329:  return "鞍";
			case 330:  return "鐵門";
			case 331:  return "紅石粉";
			case 332:  return "雪球";
			case 333:  return "船";
			case 334:  return "皮革";
			case 335:  return "牛奶";
			case 336:  return "紅磚";
			case 337:  return "粘土";
			case 338:  return "甘蔗";
			case 339:  return "紙";
			case 340:  return "書";
			case 341:  return "粘液球";
			case 342:  return "運輸礦車";
			case 343:  return "動力礦車";
			case 344:  return "蛋";
			case 345:  return "指南針";
			case 346:  return "釣魚竿";
			case 347:  return "鍾";
			case 348:  return "螢石粉";
			case 349:  return "生魚";
			case 350:  return "熟魚";
			case 351:  return "染料";
			case 352:  return "骨頭";
			case 353:  return "糖";
			case 354:  return "蛋糕";
			case 355:  return "床";
			case 356:  return "紅石中繼器";
			case 357:  return "曲奇";
			case 358:  return "地圖";
			case 359:  return "剪刀";
			case 360:  return "西瓜片";
			case 361:  return "南瓜種子";
			case 362:  return "西瓜種子";
			case 363:  return "生牛肉";
			case 364:  return "牛排";
			case 365:  return "生雞肉";
			case 366:  return "熟雞肉";
			case 367:  return "腐肉";
			case 368:  return "末影珍珠";
			case 369:  return "烈焰棒";
			case 370:  return "惡魂之淚";
			case 371:  return "金粒";
			case 372:  return "地獄疣";
			case 373:  return "藥水";
			case 374:  return "玻璃瓶";
			case 375:  return "蜘蛛眼";
			case 376:  return "發酵蛛眼";
			case 377:  return "烈焰粉";
			case 378:  return "岩漿膏";
			case 379:  return "釀造台";
			case 380:  return "煉藥鍋";
			case 381:  return "末影之眼";
			case 382:  return "閃爍的西瓜";
			case 383:  return "刷怪蛋";
			case 384:  return "附魔之瓶";
			case 385:  return "火球";
			case 386:  return "書與筆";
			case 387:  return "成書";
			case 388:  return "綠寶石";
			case 389:  return "物品展示框";
			case 390:  return "花盆";
			case 391:  return "胡蘿蔔";
			case 392:  return "馬鈴薯";
			case 393:  return "烤馬鈴薯";
			case 394:  return "毒馬鈴薯";
			case 395:  return "空地圖";
			case 396:  return "金胡蘿蔔";
			case 397:  return "頭";
			case 398:  return "蘿蔔釣竿";
			case 399:  return "下界之星";
			case 400:  return "南瓜派";
			case 401:  return "煙花火箭";
			case 402:  return "煙火之星";
			case 403:  return "附魔書";
			case 404:  return "紅石比較器";
			case 405:  return "地獄磚";
			case 406:  return "下界石英";
			case 407:  return "N礦車";
			case 408:  return "漏斗礦車";
			case 2256:  return "13號唱片";
			case 2257:  return "ca唱片";
			case 2258:  return "locks唱片";
			case 2259:  return "chrp唱片";
			case 2260:  return "far唱片";
			case 2261:  return "mall唱片";
			case 2262:  return "melloh唱片";
			case 2263:  return "sal唱片";
			case 2264:  return "sra唱片";
			case 2265:  return "war唱片";
			case 2266:  return "11號唱片";
			case 2267:  return "wa唱片";
		}
		return i.getType().name();
	}
}
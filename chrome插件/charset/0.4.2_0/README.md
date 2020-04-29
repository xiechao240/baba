# Chrome-Charset
[![Developing](https://img.shields.io/badge/Chrome--Charset-developing-yellow.svg)](https://github.com/jinliming2/Chrome-Charset)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/jinliming2/Chrome-Charset/master/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/jinliming2/Chrome-Charset.svg)](https://github.com/jinliming2/Chrome-Charset/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/jinliming2/Chrome-Charset.svg)](https://github.com/jinliming2/Chrome-Charset/network)
[![GitHub issues](https://img.shields.io/github/issues/jinliming2/Chrome-Charset.svg)](https://github.com/jinliming2/Chrome-Charset/issues)

[![Chrome Web Store Rating](https://img.shields.io/chrome-web-store/rating/oenllhgkiiljibhfagbfogdbchhdchml.svg)](https://chrome.google.com/webstore/detail/oenllhgkiiljibhfagbfogdbchhdchml)
[![Chrome Web Store Stars](https://img.shields.io/chrome-web-store/stars/oenllhgkiiljibhfagbfogdbchhdchml.svg)](https://chrome.google.com/webstore/detail/oenllhgkiiljibhfagbfogdbchhdchml)
[![Chrome Web Store Rating Count](https://img.shields.io/chrome-web-store/rating-count/oenllhgkiiljibhfagbfogdbchhdchml.svg)](https://chrome.google.com/webstore/detail/oenllhgkiiljibhfagbfogdbchhdchml)
[![Chrome Web Store Version](https://img.shields.io/chrome-web-store/v/oenllhgkiiljibhfagbfogdbchhdchml.svg)](https://chrome.google.com/webstore/detail/oenllhgkiiljibhfagbfogdbchhdchml)
[![Chrome Web Store Downloads](https://img.shields.io/chrome-web-store/d/oenllhgkiiljibhfagbfogdbchhdchml.svg)](https://chrome.google.com/webstore/detail/oenllhgkiiljibhfagbfogdbchhdchml)


A Google Chrome extension used to modify the page default encoding for Google Chrome 55+.

用于在Google Chrome浏览器下修改网站默认编码的扩展程序。

## Release
[Google Chrome Web Store](https://chrome.google.com/webstore/detail/oenllhgkiiljibhfagbfogdbchhdchml)

## History
### v0.4.2(2018/2/24)
1. 【修复】如果网站没有提供 Content-Type，则应该使用 text/plain 作为默认 Content-Type 而不是 text/html（GitHub Issue：[#5](https://github.com/jinliming2/Chrome-Charset/issues/5)）

### v0.4.1(2017/7/31)
1. 【修复】部分纯js内容的Content-Type为application/x-javascript而导致匹配失败不转换编码的问题（GitHub Issue：[#2](https://github.com/jinliming2/Chrome-Charset/issues/2)）

### v0.4(2017/7/1)
1. 新增设置选项：允许设置是否显示右键菜单（GitHub Issue：[#1](https://github.com/jinliming2/Chrome-Charset/issues/1)）
2. 将默认语言设置为英文en，中文浏览器、英文浏览器不受影响，其他语言浏览器默认显示英文。（Chrome商店反馈）

### v0.3.1(2017/5/7)
1. 【修复】file协议下修改html文档编码失败的Bug。

### v0.3(2017/4/17)
1. 增加对file://协议本地文件的支持。

### v0.2(2017/3/22)
1. 修改编码列表加载逻辑。
2. 右上角窗口检测当前编码时显示注释。
3. 添加右键菜单。
4. 添加英语支持。

### v0.1(2017/2/14)
1. 测试版，对Chrome 54选择编码功能中所列出的编码进行了支持。

var exec = require('cordova/exec');

exports.shareText = function (text, title,  success, error) {
    exec(success, error, 'NativeShare', 'shareText', [text, title]);
};

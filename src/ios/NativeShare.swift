
@objc(NativeShare) public class NativeShare : CDVPlugin  {


    @objc public func shareText(_ command: CDVInvokedUrlCommand) {
        let text = command.argument(at: 0) as! String
        let activityController = UIActivityViewController(activityItems:[text],
                                                          applicationActivities: nil)
        UIApplication.shared.keyWindow?.rootViewController?.present(activityController, animated: true, completion: nil)
    }

}

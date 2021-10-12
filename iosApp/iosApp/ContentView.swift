import SwiftUI
import shared

struct ContentView: View {
    @State private var passwordText = "🔒"
    @State private var messageText = Detector().detect()
    @State private var messageTextColor = Color.gray
    
    let validator = Validator()
    let versionText = Detector().detect()
    
    func validate() {
        validator.inspect(password: passwordText) { response, error in
            if let response = response {
                if (response.result) {
                    self.messageTextColor = Color.red
                } else {
                    self.messageTextColor = Color.green
                }
                self.messageText = response.message
            } else if let error = error {
                self.messageText = "Error: \(error)"
            }
        }
    }
    
    var body: some View {
        VStack {
            Image("ios-logo")
                .resizable()
                .aspectRatio(contentMode: .fill)
                .frame(width: 80, height: 80)
            
            Spacer()
        }
        .frame(width: 300, height: 100)
        
        VStack {
            Text(passwordText)
                .fontWeight(.bold)
                .font(.title)
                .frame(width: 250, height: 80, alignment: Alignment.center)
                .foregroundColor(.black)
            
            Text(messageText)
                .font(.subheadline)
                .foregroundColor(messageTextColor)
            
            Spacer()
        }
        .frame(width: 300, height: 150)
            
        HStack {
            Button(action: {
                messageText = versionText
                messageTextColor = Color.gray
                
                passwordText = PasswordGenerator().generate(length: 10)
            }) {
                Text("產生")
                    .frame(width: 50, height: 15, alignment: Alignment.center)
                    .foregroundColor(.green)
                    .padding()
                    .overlay(
                        RoundedRectangle(cornerRadius: 35)
                            .stroke(Color.green, lineWidth: 2)
                    )
            }
            Button(action: {
                messageText = versionText
                messageTextColor = Color.gray
                
                validate()
            }) {
                Text("檢查")
                    .frame(width: 50, height: 15, alignment: Alignment.center)
                    .foregroundColor(.red)
                    .padding()
                    .overlay(
                        RoundedRectangle(cornerRadius: 35)
                            .stroke(Color.red, lineWidth: 2)
                    )
            }
        }.frame(width: 300, height: 150)
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

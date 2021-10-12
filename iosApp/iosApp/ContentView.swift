import SwiftUI
import shared

struct ContentView: View {
    @State private var passwordText = "🔒"
    let versionText = Detector().detect()
    
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
            
            Text(versionText)
                .font(.subheadline)
                .foregroundColor(.gray)
            
            Spacer()
        }
        .frame(width: 300, height: 150)
            
        HStack {
            Button(action: {
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

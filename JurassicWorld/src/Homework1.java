// Homework 1: Jurassic World Travel Limited
// Spencer Huebler-Davis
// Due Date: 9/5/2019

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Homework1 extends Application {

	@Override
	public void start(final Stage primaryStage) {

		DecimalFormat two = new DecimalFormat("0.00");
		DecimalFormat zero = new DecimalFormat("0");
		ObservableList<String> options = FXCollections.observableArrayList("Tyrannosaurs Terror", "Stegosaurus Plates",
				"Pterodactyl Droppings");
		ObservableList<String> months = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12");
		ObservableList<String> years = FXCollections.observableArrayList("2020", "2021", "2022", "2023", "2024", "2025",
				"2026");

		// Create text objects
		Text title = new Text("Jurassic World Travel Limited");
		Text type = new Text("Package Type");
		Text adultTicket = new Text("Adult Ticket");
		Text childTicket = new Text("Child Ticket");
		Text additional = new Text("Additional");
		Text packageName1 = new Text("Tyrannosaurs Terror");
		Text packageName2 = new Text("Stegosaurus Plates");
		Text packageName3 = new Text("Pterodactyl Droppings");
		Text packageName4 = new Text("Rappin' with Raptors Encounter");
		Text adultPrice1 = new Text("$219.75");
		Text adultPrice2 = new Text("$155.00");
		Text adultPrice3 = new Text("$53.00");
		Text adultPrice4 = new Text("$80.00");
		Text childPrice1 = new Text("$195.50");
		Text childPrice2 = new Text("$120.25");
		Text childPrice3 = new Text("$26.50");
		Text childPrice4 = new Text("$55.00");
		Text select = new Text("Select Package:");
		Text adultAmount = new Text("Adult:");
		Text childAmount = new Text("Child:");
		Text childAmount2 = new Text("Child:");
		Text adultAmount2 = new Text("Rappin' with Raptors Enc. Adult:");
		Text discount = new Text("Discount (.05-.15):");
		Text first = new Text("First Name");
		Text middle = new Text("Mid Initial");
		Text last = new Text("Last Name");
		Text address = new Text("Address");
		Text city = new Text("City");
		Text state = new Text("State");
		Text zip = new Text("Zip");
		Text phone = new Text("Phone Number");
		Text credit = new Text("Credit Card Number");
		Text expiration = new Text("Exp. Date (MM/YYYY)");
		Text receipt = new Text("Receipt");
		Text packageType = new Text("Package Type:");
		Text selectedPack = new Text("Select Package");
		Text totalAdult = new Text("Total Cost for Adults:");
		Text calcAdult = new Text("$0.00");
		Text calcAdult2 = new Text("0");
		Text totalChild = new Text("Total Cost for Children:");
		Text calcChild = new Text("$0.00");
		Text calcChild2 = new Text("0");
		Text totalAdditional = new Text("Additional Fees:");
		Text calcAdditional = new Text("$0.00");
		Text calcAdditional2 = new Text("0");
		Text totalDiscount = new Text("Discount Applied:");
		Text calcDiscount = new Text("None");
		Text totalCost = new Text("Total Cost with 6% Tax:");
		Text calcCost = new Text("$0.00");
		Text custInfo = new Text("Customer Info");
		Text customerName = new Text("Customer Name");
		Text totalAddress = new Text("Address Line 1");
		Text totalAddress2 = new Text("Address Line 2");
		Text totalPhone = new Text("Phone Number");
		Text cardNum = new Text("Card Number:");
		Text totalCredit = new Text("Credit Card");
		Text totalExp = new Text("Exp. Date:");
		Text calcExp = new Text("MM/YYYY");

		// Create dropdowns, lines, and text fields
		ComboBox<String> drop = new ComboBox<String>(options);
		ComboBox<String> month = new ComboBox<String>(months);
		ComboBox<String> year = new ComboBox<String>(years);
		Button checkout = new Button("Checkout");
		Line line = new Line();
		Line line2 = new Line();
		TextField discountBox = new TextField();
		TextField numAdult = new TextField();
		TextField numChild = new TextField();
		TextField addAdult = new TextField();
		TextField addChild = new TextField();
		TextField firstName = new TextField();
		TextField midName = new TextField();
		TextField lastName = new TextField();
		TextField addressBox = new TextField();
		TextField cityBox = new TextField();
		TextField stateBox = new TextField();
		TextField zipBox = new TextField();
		TextField phoneBox = new TextField();
		TextField creditBox = new TextField();

		// Set the positions of items in the top section
		title.setX(175);
		title.setY(30);
		title.setFont(Font.font(null, FontWeight.BOLD, 18));
		type.setX(70);
		type.setY(80);
		type.setFont(Font.font(null, FontWeight.BOLD, 14));
		type.setUnderline(true);
		adultTicket.setX(250);
		adultTicket.setY(80);
		adultTicket.setFont(Font.font(null, FontWeight.BOLD, 14));
		adultTicket.setUnderline(true);
		childTicket.setX(430);
		childTicket.setY(80);
		childTicket.setFont(Font.font(null, FontWeight.BOLD, 14));
		childTicket.setUnderline(true);
		packageName1.setX(60);
		packageName1.setY(110);
		packageName2.setX(65);
		packageName2.setY(140);
		packageName3.setX(55);
		packageName3.setY(170);
		packageName4.setX(35);
		packageName4.setY(240);
		adultPrice1.setX(270);
		adultPrice1.setY(110);
		adultPrice2.setX(270);
		adultPrice2.setY(140);
		adultPrice3.setX(275);
		adultPrice3.setY(170);
		adultPrice4.setX(275);
		adultPrice4.setY(240);
		childPrice1.setX(450);
		childPrice1.setY(110);
		childPrice2.setX(450);
		childPrice2.setY(140);
		childPrice3.setX(455);
		childPrice3.setY(170);
		childPrice4.setX(455);
		childPrice4.setY(240);
		additional.setX(255);
		additional.setY(210);
		additional.setFont(Font.font(null, FontWeight.BOLD, 14));
		additional.setUnderline(true);
		line.setStartX(10);
		line.setStartY(260);
		line.setEndX(590);
		line.setEndY(260);

		// Set the positions of items in the middle section
		select.setX(30);
		select.setY(290);
		drop.setTranslateX(140);
		drop.setTranslateY(270);
		adultAmount.setX(360);
		adultAmount.setY(290);
		childAmount.setX(465);
		childAmount.setY(290);
		adultAmount2.setX(222);
		adultAmount2.setY(330);
		childAmount2.setX(465);
		childAmount2.setY(330);
		addAdult.setTranslateX(402);
		addAdult.setTranslateY(310);
		addAdult.setPrefWidth(60);
		addChild.setTranslateX(507);
		addChild.setTranslateY(310);
		addChild.setPrefWidth(60);
		discount.setX(30);
		discount.setY(330);
		discountBox.setTranslateX(140);
		discountBox.setTranslateY(310);
		discountBox.setPrefWidth(60);
		numAdult.setTranslateX(402);
		numAdult.setTranslateY(270);
		numAdult.setPrefWidth(60);
		numChild.setTranslateX(507);
		numChild.setTranslateY(270);
		numChild.setPrefWidth(60);
		first.setX(30);
		first.setY(370);
		firstName.setTranslateX(30);
		firstName.setTranslateY(380);
		firstName.setPrefWidth(160);
		middle.setX(240);
		middle.setY(370);
		midName.setTranslateX(240);
		midName.setTranslateY(380);
		midName.setPrefWidth(40);
		last.setX(340);
		last.setY(370);
		lastName.setTranslateX(340);
		lastName.setTranslateY(380);
		lastName.setPrefWidth(230);
		address.setX(30);
		address.setY(440);
		addressBox.setTranslateX(30);
		addressBox.setTranslateY(450);
		addressBox.setPrefWidth(240);
		city.setX(280);
		city.setY(440);
		cityBox.setTranslateX(280);
		cityBox.setTranslateY(450);
		cityBox.setPrefWidth(120);
		state.setX(410);
		state.setY(440);
		stateBox.setTranslateX(410);
		stateBox.setTranslateY(450);
		stateBox.setPrefWidth(50);
		zip.setX(470);
		zip.setY(440);
		zipBox.setTranslateX(470);
		zipBox.setTranslateY(450);
		zipBox.setPrefWidth(100);
		phone.setX(30);
		phone.setY(510);
		phoneBox.setTranslateX(30);
		phoneBox.setTranslateY(520);
		phoneBox.setPrefWidth(140);
		credit.setX(190);
		credit.setY(510);
		creditBox.setTranslateX(190);
		creditBox.setTranslateY(520);
		creditBox.setPrefWidth(200);
		expiration.setX(400);
		expiration.setY(510);
		month.setTranslateX(400);
		month.setTranslateY(520);
		month.setPrefWidth(60);
		year.setTranslateX(470);
		year.setTranslateY(520);
		year.setPrefWidth(70);
		line2.setStartX(10);
		line2.setStartY(570);
		line2.setEndX(590);
		line2.setEndY(570);

		// Set the positions of items in the bottom receipt section
		receipt.setX(265);
		receipt.setY(600);
		receipt.setFont(Font.font(null, FontWeight.BOLD, 14));
		packageType.setX(320);
		packageType.setY(650);
		selectedPack.setX(400);
		selectedPack.setY(650);
		totalAdult.setX(320);
		totalAdult.setY(680);
		calcAdult.setX(435);
		calcAdult.setY(680);
		totalChild.setX(320);
		totalChild.setY(710);
		calcChild.setX(445);
		calcChild.setY(710);
		totalAdditional.setX(320);
		totalAdditional.setY(740);
		calcAdditional.setX(410);
		calcAdditional.setY(740);
		totalDiscount.setX(320);
		totalDiscount.setY(770);
		calcDiscount.setX(420);
		calcDiscount.setY(770);
		totalCost.setX(320);
		totalCost.setY(830);
		calcCost.setX(450);
		calcCost.setY(830);
		calcCost.setFont(Font.font(null, FontWeight.BOLD, 12));
		checkout.setTranslateX(360);
		checkout.setTranslateY(782);
		checkout.setPrefWidth(70);
		custInfo.setX(40);
		custInfo.setY(650);
		custInfo.setUnderline(true);
		customerName.setX(40);
		customerName.setY(680);
		totalAddress.setX(40);
		totalAddress.setY(710);
		totalAddress2.setX(40);
		totalAddress2.setY(740);
		totalPhone.setX(40);
		totalPhone.setY(770);
		cardNum.setX(40);
		cardNum.setY(800);
		totalCredit.setX(120);
		totalCredit.setY(800);
		totalExp.setX(40);
		totalExp.setY(830);
		calcExp.setX(100);
		calcExp.setY(830);

		// Event on choosing a package
		drop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event1) {
				try {
					String value = drop.getValue().toString();
					if (value.equals("Tyrannosaurs Terror")) {
						double priceAdult = 219.75;
						double priceChild = 195.50;
						// Ensure an item is selected, if not set value to zero
						try {
							calcAdult.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numAdult.getText()) * priceAdult))));
							calcAdult2.setText(String.valueOf((Double.parseDouble(numAdult.getText()) * priceAdult)));
						} catch (NumberFormatException e) {
							calcAdult.setText("$0.00");
							calcAdult2.setText("0");
						}
						try {
							calcChild.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numChild.getText()) * priceChild))));
							calcChild2.setText(String.valueOf((Double.parseDouble(numChild.getText()) * priceChild)));
						} catch (NumberFormatException e) {
							calcChild.setText("$0.00");
							calcChild2.setText("0");
						}
					} else if (value.equals("Stegosaurus Plates")) {
						double priceAdult = 155.00;
						double priceChild = 120.25;
						try {
							calcAdult.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numAdult.getText()) * priceAdult))));
							calcAdult2.setText(String.valueOf((Double.parseDouble(numAdult.getText()) * priceAdult)));
						} catch (NumberFormatException e) {
							calcAdult.setText("$0.00");
							calcAdult2.setText("0");
						}
						try {
							calcChild.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numChild.getText()) * priceChild))));
							calcChild2.setText(String.valueOf((Double.parseDouble(numChild.getText()) * priceChild)));
						} catch (NumberFormatException e) {
							calcChild.setText("$0.00");
							calcChild2.setText("0");
						}
					} else if (value.equals("Pterodactyl Droppings")) {
						double priceAdult = 53.00;
						double priceChild = 26.50;
						try {
							calcAdult.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numAdult.getText()) * priceAdult))));
							calcAdult2.setText(String.valueOf((Double.parseDouble(numAdult.getText()) * priceAdult)));
						} catch (NumberFormatException e) {
							calcAdult.setText("$0.00");
							calcAdult2.setText("0");
						}
						try {
							calcChild.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numChild.getText()) * priceChild))));
							calcChild2.setText(String.valueOf((Double.parseDouble(numChild.getText()) * priceChild)));
						} catch (NumberFormatException e) {
							calcChild.setText("$0.00");
							calcChild2.setText("0");
						}
					}
				} catch (NullPointerException e) {
					calcAdult.setText("Select Package");
				}
				// Set text in receipt to that of selected package
				selectedPack.setText(drop.getValue());
			}
		});

		// Drop down for month selection
		month.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event2) {
				if (year.getValue() == null) {
					calcExp.setText(month.getValue() + "/YYYY");
				} else {
					calcExp.setText(month.getValue() + "/" + year.getValue());
				}
			}
		});

		// Drop down for year selection
		year.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event3) {
				if (month.getValue() == null) {
					calcExp.setText("MM/" + year.getValue());
				} else {
					calcExp.setText(month.getValue() + "/" + year.getValue());
				}
			}
		});

		// Change calculated adult price when number of adult tickets are
		// entered
		numAdult.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					String value = drop.getValue().toString();
					if (value.equals("Tyrannosaurs Terror")) {
						double priceAdult = 219.75;
						try {
							calcAdult.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numAdult.getText()) * priceAdult))));
							calcAdult2.setText(String.valueOf((Double.parseDouble(numAdult.getText()) * priceAdult)));
						} catch (NumberFormatException e) {
							calcAdult.setText("$0.00");
							calcAdult2.setText("0");
						}
					} else if (value.equals("Stegosaurus Plates")) {
						double priceAdult = 155.00;
						try {
							calcAdult.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numAdult.getText()) * priceAdult))));
							calcAdult2.setText(String.valueOf((Double.parseDouble(numAdult.getText()) * priceAdult)));
						} catch (NumberFormatException e) {
							calcAdult.setText("$0.00");
							calcAdult2.setText("0");
						}
					} else if (value.equals("Pterodactyl Droppings")) {
						double priceAdult = 53.00;
						try {
							calcAdult.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numAdult.getText()) * priceAdult))));
							calcAdult2.setText(String.valueOf((Double.parseDouble(numAdult.getText()) * priceAdult)));
						} catch (NumberFormatException e) {
							calcAdult.setText("$0.00");
							calcAdult.setText("0");
						}
					}
				} catch (NullPointerException e) {
					calcAdult.setText("Select a Package");
				}
			}
		});

		// Change calculated child price when number of child tickets are
		// entered
		numChild.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					String value = drop.getValue().toString();
					if (value.equals("Tyrannosaurs Terror")) {
						double priceChild = 195.50;
						try {
							calcChild.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numChild.getText()) * priceChild))));
							calcChild2.setText(String.valueOf((Double.parseDouble(numChild.getText()) * priceChild)));
						} catch (NumberFormatException e) {
							calcChild.setText("$0.00");
							calcAdult2.setText("0");
						}
					} else if (value.equals("Stegosaurus Plates")) {
						double priceChild = 120.25;
						try {
							calcChild.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numChild.getText()) * priceChild))));
							calcChild2.setText(String.valueOf((Double.parseDouble(numChild.getText()) * priceChild)));
						} catch (NumberFormatException e) {
							calcChild.setText("$0.00");
							calcAdult2.setText("0");
						}
					} else if (value.equals("Pterodactyl Droppings")) {
						double priceChild = 26.50;
						try {
							calcChild.setText(String
									.valueOf("$" + two.format((Double.parseDouble(numChild.getText()) * priceChild))));
							calcChild2.setText(String.valueOf((Double.parseDouble(numChild.getText()) * priceChild)));
						} catch (NumberFormatException e) {
							calcChild.setText("$0.00");
							calcAdult2.setText("0");
						}
					}
				} catch (NullPointerException e) {
					calcChild.setText("Select a Package");
				}
			}
		});

		// Display discount when entered, or else show none
		discountBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					calcDiscount.setText(
							String.valueOf(zero.format(Double.parseDouble(discountBox.getText()) * 100)) + "%");
				} catch (NumberFormatException e) {
					calcDiscount.setText("None");
				}
			}
		});

		// Change calculated additional charges for adults
		addAdult.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					calcAdditional.setText("$" + String.valueOf(two.format((Double.parseDouble(addAdult.getText()) * 80)
							+ Double.parseDouble(addChild.getText()) * 55)));
					calcAdditional2.setText(String.valueOf(two.format((Double.parseDouble(addAdult.getText()) * 80)
							+ Double.parseDouble(addChild.getText()) * 55)));
				} catch (NumberFormatException e) {
					try {
						calcAdditional
								.setText("$" + String.valueOf(two.format(Double.parseDouble(addAdult.getText()) * 80)));
						calcAdditional2
								.setText(String.valueOf(two.format(Double.parseDouble(addAdult.getText()) * 80)));
					} catch (NumberFormatException f) {
						calcAdditional.setText("$0.00");
						calcAdditional2.setText("0");
					}
				}
			}
		});

		// Change calculated additional charges for children
		addChild.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					calcAdditional.setText("$" + String.valueOf(two.format((Double.parseDouble(addAdult.getText()) * 80)
							+ Double.parseDouble(addChild.getText()) * 55)));
					calcAdditional2.setText(String.valueOf(two.format((Double.parseDouble(addAdult.getText()) * 80)
							+ Double.parseDouble(addChild.getText()) * 55)));
				} catch (NumberFormatException e) {
					try {
						calcAdditional
								.setText("$" + String.valueOf(two.format(Double.parseDouble(addChild.getText()) * 55)));
						calcAdditional2
								.setText(String.valueOf(two.format(Double.parseDouble(addChild.getText()) * 55)));
					} catch (NumberFormatException f) {
						calcAdditional.setText("$0.00");
						calcAdditional2.setText("0");
					}
				}
			}
		});

		// User listeners to display all customer info in real time on receipt
		firstName.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				customerName.setText(firstName.getText() + " " + midName.getText() + " " + lastName.getText());
			}
		});

		midName.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				customerName.setText(firstName.getText() + " " + midName.getText() + " " + lastName.getText());
			}
		});

		lastName.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				customerName.setText(firstName.getText() + " " + midName.getText() + ". " + lastName.getText());
			}
		});

		addressBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				totalAddress.setText(addressBox.getText());
			}
		});

		cityBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				totalAddress2.setText(cityBox.getText() + " " + stateBox.getText() + " " + zipBox.getText());
			}
		});

		stateBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				totalAddress2.setText(cityBox.getText() + ", " + stateBox.getText() + " " + zipBox.getText());
			}
		});

		zipBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				totalAddress2.setText(cityBox.getText() + ", " + stateBox.getText() + " " + zipBox.getText());
			}
		});

		phoneBox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				totalPhone.setText(phoneBox.getText());
			}
		});

		// Listener to display credit card type
		creditBox.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				totalCredit.setText(creditBox.getText());
			}
		});

		// Button to calculate final cost for customer
		checkout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event1) {
				try {
					double beforeDiscount = ((Double.parseDouble(calcAdult2.getText()))
							+ (Double.parseDouble(calcChild2.getText()))
							+ Double.parseDouble(calcAdditional2.getText()));
					double withDiscount = beforeDiscount * (Double.parseDouble(discountBox.getText()));
					double noTax = beforeDiscount - withDiscount;
					double endCost = (noTax * .06) + noTax;
					calcCost.setText("$" + String.valueOf(two.format(endCost)));
				} catch (NumberFormatException e) {
					double beforeDiscount = ((Double.parseDouble(calcAdult2.getText()))
							+ (Double.parseDouble(calcChild2.getText()))
							+ Double.parseDouble(calcAdditional2.getText()));
					double endCost = (beforeDiscount * .06) + beforeDiscount;
					calcCost.setText("$" + String.valueOf(two.format(endCost)));
				}
			}
		});

		// Create the pane and place each item inside, then show the primary
		// stage
		Pane root = new Pane();
		root.getChildren().addAll(title, type, adultTicket, childTicket, packageName1, packageName2, packageName3,
				packageName4, adultPrice1, adultPrice2, adultPrice3, adultPrice4, childPrice1, childPrice2, childPrice3,
				childPrice4, additional, line, select, drop, adultAmount, childAmount, numAdult, numChild, adultAmount2,
				childAmount2, addAdult, addChild, discount, discountBox, first, firstName, middle, midName, last,
				lastName, address, addressBox, city, cityBox, state, stateBox, zip, zipBox, phone, phoneBox, credit,
				creditBox, expiration, month, year, line2, receipt, packageType, selectedPack, totalAdult, calcAdult,
				totalChild, calcChild, totalAdditional, calcAdditional, totalDiscount, calcDiscount, totalCost,
				calcCost, custInfo, customerName, totalAddress, totalAddress2, totalPhone, cardNum, totalCredit,
				totalExp, calcExp, calcAdult2, calcChild2, calcAdditional2, checkout);
		Scene scene = new Scene(root, 600, 860);
		primaryStage.setTitle("Jurassic World Travel Limited");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// Main method for launching
	public static void main(String[] args) {
		launch(args);
	}
}